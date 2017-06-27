package com.ztest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztest.mapper.MemberMapper;
import com.ztest.mapper.TeamMapper;
import com.ztest.vo.Member;
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
public class MemberService {

@Autowired
private MemberMapper memberMapper;

public Member selectLogin(Member params) throws Exception {
	Member member = null;

	member = memberMapper.selectLogin(params);
	
	if(member != null){
		return member;
	}else{
		return new Member();
	}
}

}
