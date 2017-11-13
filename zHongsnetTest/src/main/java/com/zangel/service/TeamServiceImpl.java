package com.zangel.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zangel.dao.CommonDao;
import com.zangel.mapper.TeamMapper;
import com.zangel.vo.Team;

/**
 * <pre>
 * 팀 서비스
 * @author H.N.Kim
 * @version
 * @since 2016-05-02
 * @see
 * @History
 *  Date         			 |    author    | 변경내용
 *  2016. 05. 02.         |    H.N.Kim       | 신규
 * @Todo
 * </pre>
 */ 
@Service
public class TeamServiceImpl implements TeamService{

	private static final Logger logger = LoggerFactory.getLogger(TeamServiceImpl.class);
	
	
	// --------------------------------------------------------------------------
	// # DAO 설정
	// --------------------------------------------------------------------------
	@Resource(name="commonDao")
	private CommonDao commonDao;
	
	@Autowired
	private TeamMapper teamMapper;

	/**
	 * <pre>
	 * Team 리스트 조회
	 * @param 
	 * @return List<Team>
	 * @throws Exception
	 * @date 2016-05-02
	 * @author H.N.Kim
	 * @비고
	 *
	 * </pre>
	 */
	@Override
	public List<Team> selectTeamList() throws Exception {
		logger.debug("TeamServiceImpl/selectTeamList :: START");
		List<Team> teamList =null;
//		teamList = commonDao.selectTeamList();
		teamList = teamMapper.selectTeamList();
		
		return teamList;
	}
	
	/**
	 * <pre>
	 * 트랜잭션 테스트
	 * @param 
	 * @return int
	 * @throws Exception
	 * @date 2016-07-11
	 * @author H.N.Kim
	 * @비고
	 *
	 * </pre>
	 */
	@Override
	public int testTransact() throws Exception {
		int ret = commonDao.testTransact();
		
		//강제 exception을 날려보자
		String str = null;
		str.length();
		
		return ret;
	}
	
	


}
