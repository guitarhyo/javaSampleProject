package com.ztest.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ztest.dao.CommonDao;
import com.ztest.service.TeamService;

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

	@Autowired
	private TeamService teamService;

	
	@RequestMapping("/test")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> inParam) throws Exception{
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


}
