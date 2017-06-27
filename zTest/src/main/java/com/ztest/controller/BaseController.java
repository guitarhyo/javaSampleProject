package com.ztest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ztest.service.MemberService;
import com.ztest.service.TeamService;
import com.ztest.vo.Member;
import com.ztest.vo.Team;

/**
 * <pre>
 * 공통 Controller
 * 공통 처리를 위한 컨트롤러
 * @author N.H.KIM
 * @version
 * @since 2016. 4. 14. 오후 9:46:37
 * @see
 * @History
 * Date				|	author		| 변경 내용
 * 2016. 4. 14.	|	N.H.KIM	|신규
 * @비고
 * </pre>
 */
@Controller
public class BaseController {


	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MessageSourceAccessor msa;


	
	@RequestMapping("/test")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> inParam) throws Exception{
		 logger.debug("BaseController/test :: START");
		ModelAndView mav = new ModelAndView();
		
		try {
			
			mav.setViewName("test");
			
			
			mav.addObject("list",teamService.selectTeamList());
			mav.addObject("params","Hello World!! spring");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> inParam) throws Exception{
		 logger.debug("BaseController/test2 :: START");
		ModelAndView mav = new ModelAndView();
		
		try {
			
			mav.setViewName("test");
			
			
			mav.addObject("list",teamService.selectTeamList());
			mav.addObject("params","Hello World!! spring");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value="/getdetail.json",  consumes="application/json", produces="application/json")
	public @ResponseBody List<Team> getdetail(  ModelAndView mv, HttpSession session) throws Exception {
	
		
		List<Team> teamList = new ArrayList<Team>();
		Team team = new Team();
		team.setAge("1");
		teamList.add(team);
		team.setAge("2");
		teamList.add(team);
		
		return teamList;
	}
	
	
	@RequestMapping(value="/testTransact")
	public @ResponseBody String testTransact(  ModelAndView mv, HttpSession session) throws Exception {
	
		
		teamService.testTransact();
		
		return "";
	}
	
	
	@RequestMapping(value="/loginJson")
	public @ResponseBody Member login(Member member,  ModelAndView mv, HttpSession session) throws Exception {
		 logger.debug("BaseController/login.json :: START");
		Member resultMember = memberService.selectLogin(member);
		
		if(resultMember != null){
			String loginId = resultMember.getLogin_id();
			if(loginId != null && !"".equals(loginId)){
				session.setAttribute("USERSESSION", loginId);
			}else{
				session.removeAttribute("USERSESSION");
			}
		}
		
		return resultMember;
	}

	@RequestMapping("/login")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> inParam) throws Exception{
		 logger.debug("BaseController/loginPage :: START");
		ModelAndView mav = new ModelAndView();
	
		return new ModelAndView("member/signIn");
	}
	
	
	@RequestMapping("/app/test")
	public ModelAndView apptest(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> inParam) throws Exception{
		 logger.debug("BaseController/apptest :: START");

		String code = "test";
		String message = msa.getMessage(code);//properties 파일의 코드의 메시지를 가져온다
		
		ModelMap map = new ModelMap();
		map.put("message", message);
		
		return new ModelAndView("app/test",map);
	}
	
	
	
}
