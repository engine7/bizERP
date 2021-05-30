package egovframework.bizerp.hmr.employment.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.bizerp.hmr.employment.service.EmploymentService;
import egovframework.bizerp.hmr.employment.service.EmploymentDefaultVO;
import egovframework.bizerp.hmr.employment.service.EmploymentVO;
import egovframework.bizerp.hmr.employment.service.impl.EmploymentDAO;
//import egovframework.bizerp.hr.service.impl.EmploymentMapper;
/**
 * @Class Name : EmploymentServiceImpl.java
 * @Description : Employment Business Implement class
 * @Modification Information
 *
 * @author 이성권
 * @since 2020-08-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("employmentService")
public class EmploymentServiceImpl extends EgovAbstractServiceImpl implements
        EmploymentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(EmploymentServiceImpl.class);

    //@Resource(name="employmentMapper")
    //private EmploymentMapper employmentDAO;
    
    @Resource(name="employmentDAO")
    private EmploymentDAO employmentDAO;
    
    /** ID Generation */
    //@Resource(name="{egovEmploymentIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * employment을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EmploymentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertEmployment(EmploymentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	employmentDAO.insertEmployment(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * employment을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EmploymentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateEmployment(EmploymentVO vo) throws Exception {
        employmentDAO.updateEmployment(vo);
    }

    /**
	 * employment을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EmploymentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteEmployment(EmploymentVO vo) throws Exception {
        employmentDAO.deleteEmployment(vo);
    }

    /**
	 * employment을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EmploymentVO
	 * @return 조회한 employment
	 * @exception Exception
	 */
    public EmploymentVO selectEmployment(EmploymentVO vo) throws Exception {
        EmploymentVO resultVO = employmentDAO.selectEmployment(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * employment 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return employment 목록
	 * @exception Exception
	 */
    public List<?> selectEmploymentList(EmploymentDefaultVO searchVO) throws Exception {
        return employmentDAO.selectEmploymentList(searchVO);
    }

    /**
	 * employment 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return employment 총 갯수
	 * @exception
	 */
    public int selectEmploymentListTotCnt(EmploymentDefaultVO searchVO) {
		return employmentDAO.selectEmploymentListTotCnt(searchVO);
	}
    
}
