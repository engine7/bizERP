package egovframework.bizerp.hmr.employees.service;

import java.util.List;
import egovframework.bizerp.hmr.employees.service.EmployeesDefaultVO;
import egovframework.bizerp.hmr.employees.service.EmployeesVO;

/**
 * @Class Name : EmployeesService.java
 * @Description : Employees Business class
 * @Modification Information
 *
 * @author 이성권
 * @since 2020-08-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface EmployeesService {
	
	/**
	 * employees을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EmployeesVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertEmployees(EmployeesVO vo) throws Exception;
    
    /**
	 * employees을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EmployeesVO
	 * @return void형
	 * @exception Exception
	 */
    void updateEmployees(EmployeesVO vo) throws Exception;
    
    /**
	 * employees을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EmployeesVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteEmployees(EmployeesVO vo) throws Exception;
    
    /**
	 * employees을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EmployeesVO
	 * @return 조회한 employees
	 * @exception Exception
	 */
    EmployeesVO selectEmployees(EmployeesVO vo) throws Exception;
    
    /**
	 * employees 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return employees 목록
	 * @exception Exception
	 */
    List selectEmployeesList(EmployeesDefaultVO searchVO) throws Exception;
    
    /**
	 * employees 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return employees 총 갯수
	 * @exception
	 */
    int selectEmployeesListTotCnt(EmployeesDefaultVO searchVO);
    
}
