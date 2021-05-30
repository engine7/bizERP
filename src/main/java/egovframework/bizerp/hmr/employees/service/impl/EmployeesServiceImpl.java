package egovframework.bizerp.hmr.employees.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.bizerp.hmr.employees.service.EmployeesService;
import egovframework.bizerp.hmr.employees.service.EmployeesDefaultVO;
import egovframework.bizerp.hmr.employees.service.EmployeesVO;
import egovframework.bizerp.hmr.employees.service.impl.EmployeesDAO;
//import egovframework.bizerp.hmr.service.impl.EmployeesMapper;
/**
 * @Class Name : EmployeesServiceImpl.java
 * @Description : Employees Business Implement class
 * @Modification Information
 *
 * @author 이성권
 * @since 2020-08-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("employeesService")
public class EmployeesServiceImpl extends EgovAbstractServiceImpl implements
        EmployeesService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesServiceImpl.class);

    //@Resource(name="employeesMapper")
    //private EmployeesMapper employeesDAO;
    
    @Resource(name="employeesDAO")
    private EmployeesDAO employeesDAO;
    
    /** ID Generation */
    //@Resource(name="{egovEmployeesIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * employees을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EmployeesVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertEmployees(EmployeesVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	employeesDAO.insertEmployees(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * employees을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EmployeesVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateEmployees(EmployeesVO vo) throws Exception {
        employeesDAO.updateEmployees(vo);
    }

    /**
	 * employees을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EmployeesVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteEmployees(EmployeesVO vo) throws Exception {
        employeesDAO.deleteEmployees(vo);
    }

    /**
	 * employees을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EmployeesVO
	 * @return 조회한 employees
	 * @exception Exception
	 */
    public EmployeesVO selectEmployees(EmployeesVO vo) throws Exception {
        EmployeesVO resultVO = employeesDAO.selectEmployees(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * employees 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return employees 목록
	 * @exception Exception
	 */
    public List<?> selectEmployeesList(EmployeesDefaultVO searchVO) throws Exception {
        return employeesDAO.selectEmployeesList(searchVO);
    }

    /**
	 * employees 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return employees 총 갯수
	 * @exception
	 */
    public int selectEmployeesListTotCnt(EmployeesDefaultVO searchVO) {
		return employeesDAO.selectEmployeesListTotCnt(searchVO);
	}
    
}
