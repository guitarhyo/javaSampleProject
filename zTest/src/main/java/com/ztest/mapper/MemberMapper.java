package com.ztest.mapper;

import org.springframework.stereotype.Repository;

import com.ztest.vo.Member;


@Repository(value="MemberMapper")
public interface MemberMapper {

	public Member selectLogin(Member params) throws Exception;
	
}


