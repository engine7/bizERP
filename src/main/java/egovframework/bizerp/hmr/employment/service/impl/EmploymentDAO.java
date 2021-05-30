package egovframework.bizerp.hmr.employment.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.bizerp.hmr.employment.service.EmploymentVO;
import egovframework.bizerp.hmr.employment.service.EmploymentDefaultVO;

/**
 * @Class Name : EmploymentDAO.java
 * @Description : Employment DAO Class
 * @Modification Information
 *
 * @author 이성권
 * @since 2020-08-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("employmentDAO")
public class EmploymentDAO extends EgovAbstractDAO {

	/**
	 * employment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EmploymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertEmployment(EmploymentVO vo) throws Exception {
        return (String)insert("employmentDAO.insertEmployment_S", vo);
    }

    /**
	 * employment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EmploymentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateEmployment(EmploymentVO vo) throws Exception {
        update("employmentDAO.updateEmployment_S", vo);
    }

    /**
	 * employment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EmploymentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteEmployment(EmploymentVO vo) throws Exception {
        delete("employmentDAO.deleteEmployment_S", vo);
    }

    /**
	 * employment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EmploymentVO
	 * @return 조회한 employment
	 * @exception Exception
	 */
    public EmploymentVO selectEmployment(EmploymentVO vo) throws Exception {
        return (EmploymentVO) select("employmentDAO.selectEmployment_S", vo);
    }

    /**
	 * employment 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return employment 목록
	 * @exception Exception
	 */
    public List<?> selectEmploymentList(EmploymentDefaultVO searchVO) throws Exception {
        return list("employmentDAO.selectEmploymentList_D", searchVO);
    }

    /**
	 * employment 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return employment 총 갯수
	 * @exception
	 */
    public int selectEmploymentListTotCnt(EmploymentDefaultVO searchVO) {
        return (Integer)select("employmentDAO.selectEmploymentListTotCnt_S", searchVO);
    }

}
