package egovframework.bizerp.hmr.employees.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.bizerp.hmr.employees.service.EmployeesVO;
import egovframework.bizerp.hmr.employees.service.EmployeesDefaultVO;

/**
 * @Class Name : EmployeesDAO.java
 * @Description : Employees DAO Class
 * @Modification Information
 *
 * @author 이성권
 * @since 2020-08-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("employeesDAO")
public class EmployeesDAO extends EgovAbstractDAO {

	/**
	 * employees을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EmployeesVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertEmployees(EmployeesVO vo) throws Exception {
        return (String)insert("employeesDAO.insertEmployees_S", vo);
    }

    /**
	 * employees을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EmployeesVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateEmployees(EmployeesVO vo) throws Exception {
        update("employeesDAO.updateEmployees_S", vo);
    }

    /**
	 * employees을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EmployeesVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteEmployees(EmployeesVO vo) throws Exception {
        delete("employeesDAO.deleteEmployees_S", vo);
    }

    /**
	 * employees을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EmployeesVO
	 * @return 조회한 employees
	 * @exception Exception
	 */
    public EmployeesVO selectEmployees(EmployeesVO vo) throws Exception {
        return (EmployeesVO) select("employeesDAO.selectEmployees_S", vo);
    }

    /**
	 * employees 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return employees 목록
	 * @exception Exception
	 */
    public List<?> selectEmployeesList(EmployeesDefaultVO searchVO) throws Exception {
        return list("employeesDAO.selectEmployeesList_D", searchVO);
    }

    /**
	 * employees 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return employees 총 갯수
	 * @exception
	 */
    public int selectEmployeesListTotCnt(EmployeesDefaultVO searchVO) {
        return (Integer)select("employeesDAO.selectEmployeesListTotCnt_S", searchVO);
    }

}
