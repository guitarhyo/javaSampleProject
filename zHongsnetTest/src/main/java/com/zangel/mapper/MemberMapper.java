package com.zangel.mapper;

import org.springframework.stereotype.Repository;

import com.zangel.vo.Member;


@Repository(value="MemberMapper")
public interface MemberMapper {

	public Member selectLogin(Member params) throws Exception;
	
}


