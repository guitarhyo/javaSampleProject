package com.ztest.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ztest.vo.Team;


@Repository(value="TeamMapper")
public interface TeamMapper {

	public List<Team> selectTeamList() throws Exception;
	
}


