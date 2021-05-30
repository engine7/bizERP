package egovframework.bizerp.hmr.employment.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.bizerp.hmr.employment.service.EmploymentService;
import egovframework.bizerp.hmr.employment.service.EmploymentDefaultVO;
import egovframework.bizerp.hmr.employment.service.EmploymentVO;

/**
 * @Class Name : EmploymentController.java
 * @Description : Employment Controller class
 * @Modification Information
 *
 * @author 이성권
 * @since 2020-08-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=EmploymentVO.class)
public class EmploymentController {

    @Resource(name = "employmentService")
    private EmploymentService employmentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * employment 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 EmploymentDefaultVO
	 * @return "/bizerp/hr/employment/EmploymentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/employment/EmploymentList.do")
    public String selectEmploymentList(@ModelAttribute("searchVO") EmploymentDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> employmentList = employmentService.selectEmploymentList(searchVO);
        model.addAttribute("resultList", employmentList);
        
        int totCnt = employmentService.selectEmploymentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/bizerp/hr/employment/EmploymentList";
    } 
    
    @RequestMapping("/employment/addEmploymentView.do")
    public String addEmploymentView(
            @ModelAttribute("searchVO") EmploymentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("employmentVO", new EmploymentVO());
        return "/bizerp/hr/employment/EmploymentRegister";
    }
    
    @RequestMapping("/employment/addEmployment.do")
    public String addEmployment(
            EmploymentVO employmentVO,
            @ModelAttribute("searchVO") EmploymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        employmentService.insertEmployment(employmentVO);
        status.setComplete();
        return "forward:/employment/EmploymentList.do";
    }
    
    @RequestMapping("/employment/updateEmploymentView.do")
    public String updateEmploymentView(
            @RequestParam("roleTypeIdFrom") java.lang.String roleTypeIdFrom ,
            @ModelAttribute("searchVO") EmploymentDefaultVO searchVO, Model model)
            throws Exception {
        EmploymentVO employmentVO = new EmploymentVO();
        employmentVO.setRoleTypeIdFrom(roleTypeIdFrom);        
        // 변수명은 CoC 에 따라 employmentVO
        model.addAttribute(selectEmployment(employmentVO, searchVO));
        return "/bizerp/hr/employment/EmploymentRegister";
    }

    @RequestMapping("/employment/selectEmployment.do")
    public @ModelAttribute("employmentVO")
    EmploymentVO selectEmployment(
            EmploymentVO employmentVO,
            @ModelAttribute("searchVO") EmploymentDefaultVO searchVO) throws Exception {
        return employmentService.selectEmployment(employmentVO);
    }

    @RequestMapping("/employment/updateEmployment.do")
    public String updateEmployment(
            EmploymentVO employmentVO,
            @ModelAttribute("searchVO") EmploymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        employmentService.updateEmployment(employmentVO);
        status.setComplete();
        return "forward:/employment/EmploymentList.do";
    }
    
    @RequestMapping("/employment/deleteEmployment.do")
    public String deleteEmployment(
            EmploymentVO employmentVO,
            @ModelAttribute("searchVO") EmploymentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        employmentService.deleteEmployment(employmentVO);
        status.setComplete();
        return "forward:/employment/EmploymentList.do";
    }

}
