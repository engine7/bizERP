package egovframework.bizerp.hmr.employees.web;

import java.util.Date;
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
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.bizerp.hmr.employees.service.EmployeesService;
import egovframework.bizerp.hmr.employees.service.EmployeesDefaultVO;
import egovframework.bizerp.hmr.employees.service.EmployeesVO;
import egovframework.com.cmm.LoginVO;
import egovframework.let.utl.fcc.service.EgovDateUtil;
import egovframework.let.utl.fcc.service.EgovStringUtil;

/**
 * @Class Name : EmployeesController.java
 * @Description : Employees Controller class
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
@SessionAttributes(types=EmployeesVO.class)
public class EmployeesController {

    @Resource(name = "employeesService")
    private EmployeesService employeesService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * employees 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 EmployeesDefaultVO
	 * @return "/bizerp/hr/employees/EmployeesList"
	 * @exception Exception
	 */
    @RequestMapping(value="/bizerp/hmr/employees/EmployeesList.do")
    public String selectEmployeesList(@ModelAttribute("searchVO") EmployeesDefaultVO searchVO, 
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
		
        List<?> employeesList = employeesService.selectEmployeesList(searchVO);
        model.addAttribute("resultList", employeesList);
        
        int totCnt = employeesService.selectEmployeesListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/bizerp/hmr/employees/EmployeesList";
    } 
    
    @RequestMapping("/bizerp/hmr/employees/addEmployeesView.do")
    public String addEmployeesView(
            @ModelAttribute("searchVO") EmployeesDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("employeesVO", new EmployeesVO());
        return "/bizerp/hmr/employees/EmployeesRegister";
    }
    
    @RequestMapping("/bizerp/hmr/employees/addEmployees.do")
    public String addEmployees(
            EmployeesVO employeesVO,
            @ModelAttribute("searchVO") EmployeesDefaultVO searchVO, SessionStatus status)
            throws Exception {
    	
    	// 1. 세션정보
    	LoginVO session = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    	String loginId = session.getId();
    	
    	employeesVO.setCreatedByUserLogin(loginId);
    	employeesVO.setLastModifiedByUserLogin(loginId);
    	
    	// 2. 날짜 (시스템컬럼)
    	Date today = new Date();
    	employeesVO.setCreatedDate(today);
    	employeesVO.setLastModifiedDate(today);
    	
    	// 2. 타임스탬프 (시스템컬럼)
    	//String timestamp = EgovStringUtil.getTimeStamp();
    	
    	employeesVO.setCreatedStamp(today);
    	employeesVO.setCreatedTxStamp(today);
    	employeesVO.setLastUpdatedStamp(today);
    	employeesVO.setLastUpdatedTxStamp(today);
    	
    	
        employeesService.insertEmployees(employeesVO);
        status.setComplete();
        return "forward:/bizerp/hmr/employees/EmployeesList.do";
    }
    
    @RequestMapping("/bizerp/hmr/employees/updateEmployeesView.do")
    public String updateEmployeesView(
            @RequestParam("roleTypeIdFrom") java.lang.String roleTypeIdFrom ,
            @ModelAttribute("searchVO") EmployeesDefaultVO searchVO, Model model)
            throws Exception {
        EmployeesVO employeesVO = new EmployeesVO();
        //employeesVO.setRoleTypeIdFrom(roleTypeIdFrom);        
        // 변수명은 CoC 에 따라 employeesVO
        model.addAttribute(selectEmployees(employeesVO, searchVO));
        return "/bizerp/hmr/employees/EmployeesRegister";
    }

    @RequestMapping("/bizerp/hmr/employees/selectEmployees.do")
    public @ModelAttribute("employeesVO")
    EmployeesVO selectEmployees(
            EmployeesVO employeesVO,
            @ModelAttribute("searchVO") EmployeesDefaultVO searchVO) throws Exception {
        return employeesService.selectEmployees(employeesVO);
    }

    @RequestMapping("/bizERP/employees/updateEmployees.do")
    public String updateEmployees(
            EmployeesVO employeesVO,
            @ModelAttribute("searchVO") EmployeesDefaultVO searchVO, SessionStatus status)
            throws Exception {
        employeesService.updateEmployees(employeesVO);
        status.setComplete();
        return "forward:/bizerp/hmr/employees/EmployeesList.do";
    }
    
    @RequestMapping("/bizerp/hmr/employees/deleteEmployees.do")
    public String deleteEmployees(
            EmployeesVO employeesVO,
            @ModelAttribute("searchVO") EmployeesDefaultVO searchVO, SessionStatus status)
            throws Exception {
        employeesService.deleteEmployees(employeesVO);
        status.setComplete();
        return "forward:/bizerp/hmr/employees/EmployeesList.do";
    }

}
