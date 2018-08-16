package com.zangel.controller;

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

import com.zangel.service.MemberService;
import com.zangel.service.TeamService;
import com.zangel.vo.Member;

/**
 * <pre>
 * 공통 Controller
 * 공통 처리를 위한 컨트롤러
 * &#64;author N.H.KIM
 * &#64;version
 * &#64;since 2016. 4. 14. 오후 9:46:37
 * &#64;see
 * &#64;History
 * Date				|	author		| 변경 내용
 * 2016. 4. 14.	|	N.H.KIM	|신규
 * &#64;비고
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



  @RequestMapping("/test.do")
  public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
      @RequestParam Map<String, Object> inParam) throws Exception {
    logger.debug("BaseController/test :: START");
    ModelAndView mav = new ModelAndView();

    try {

      mav.setViewName("test");


      mav.addObject("list", teamService.selectTeamList());
      mav.addObject("params", "Hello World!! spring");

    } catch (Exception e) {
      e.printStackTrace();
    }
    return mav;
  }

  // 트랜잭션 테스트
  @RequestMapping(value = "/testTransact.do")
  public @ResponseBody String testTransact(ModelAndView mv, HttpSession session) throws Exception {


    teamService.testTransact();

    return "";
  }


  @RequestMapping(value = "/loginJson.do")
  public @ResponseBody Member login(Member member, ModelAndView mv, HttpSession session)
      throws Exception {
    logger.debug("BaseController/login.json :: START");
    Member resultMember = memberService.selectLogin(member);

    if (resultMember != null) {
      String loginId = resultMember.getLogin_id();
      if (loginId != null && !"".equals(loginId)) {
        session.setAttribute("USERSESSION", loginId);
      } else {
        session.removeAttribute("USERSESSION");
      }
    }

    return resultMember;
  }

  @RequestMapping("/login.do")
  public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response,
      @RequestParam Map<String, Object> inParam) throws Exception {
    logger.debug("BaseController/loginPage :: START");
    ModelAndView mav = new ModelAndView();

    return new ModelAndView("member/signIn");
  }


  @RequestMapping("/app/test.do")
  public ModelAndView apptest(HttpServletRequest request, HttpServletResponse response,
      @RequestParam Map<String, Object> inParam) throws Exception {
    logger.debug("BaseController/apptest :: START");

    String code = "test";
    String message = msa.getMessage(code);// properties 파일의 코드의 메시지를 가져온다

    ModelMap map = new ModelMap();
    map.put("message", message);

    return new ModelAndView("app/test", map);
  }


}
