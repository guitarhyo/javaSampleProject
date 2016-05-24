package com.ztest.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztest.dao.CommonDao;
import com.ztest.vo.Team;

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

	// --------------------------------------------------------------------------
	// # DAO 설정
	// --------------------------------------------------------------------------
	@Resource(name="commonDao")
	private CommonDao commonDao;

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
		List<Team> teamList =null;
		teamList = commonDao.selectTeamList();
		
		System.out.println(teamList.toString());
		return teamList;
	}
	
	


}
