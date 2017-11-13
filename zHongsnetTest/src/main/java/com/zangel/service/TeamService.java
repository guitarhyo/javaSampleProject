package com.zangel.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zangel.vo.Team;

/**
 * <pre>
 * 팀 서비스
 * &#64;author H.N.Kim
 * &#64;version
 * &#64;since 2016-05-02
 * &#64;see
 * &#64;History
 *  Date         			 |    author    | 변경내용
 *  2016. 05. 02.         |    H.N.Kim       | 신규
 * &#64;Todo
 * </pre>
 */
@Transactional // 서비스 전체 또는 각각 줄수 있으며 전체를 주었을땐 읽기 전용은 옵션을 주도록한다.
public interface TeamService {

  @Transactional(readOnly = true)
  public List<Team> selectTeamList() throws Exception;

  @Transactional
  public int testTransact() throws Exception;

}
