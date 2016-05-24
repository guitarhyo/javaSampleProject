package com.ztest.service;

import java.util.List;

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
public interface TeamService {

	public List<Team> selectTeamList() throws Exception;
	
}
