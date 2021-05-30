package egovframework.bizerp.hmr.employment.service;

import java.util.List;
import egovframework.bizerp.hmr.employment.service.EmploymentDefaultVO;
import egovframework.bizerp.hmr.employment.service.EmploymentVO;

/**
 * @Class Name : EmploymentService.java
 * @Description : Employment Business class
 * @Modification Information
 *
 * @author 이성권
 * @since 2020-08-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface EmploymentService {
	
	/**
	 * employment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EmploymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertEmployment(EmploymentVO vo) throws Exception;
    
    /**
	 * employment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EmploymentVO
	 * @return void형
	 * @exception Exception
	 */
    void updateEmployment(EmploymentVO vo) throws Exception;
    
    /**
	 * employment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EmploymentVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteEmployment(EmploymentVO vo) throws Exception;
    
    /**
	 * employment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EmploymentVO
	 * @return 조회한 employment
	 * @exception Exception
	 */
    EmploymentVO selectEmployment(EmploymentVO vo) throws Exception;
    
    /**
	 * employment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return employment 목록
	 * @exception Exception
	 */
    List selectEmploymentList(EmploymentDefaultVO searchVO) throws Exception;
    
    /**
	 * employment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return employment 총 갯수
	 * @exception
	 */
    int selectEmploymentListTotCnt(EmploymentDefaultVO searchVO);
    
}
