package com.ztest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);
	/**
	 * preHandle
	 *
	 * controller 호출전
	 */
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {


		logger.info("########################  REQUEST   ############################");
		logger.info("# Host           = {}", request.getRemoteHost());
		logger.info("# Method         = {}", request.getMethod());
		logger.info("# RequestURL     = {}", request.getRequestURL().toString());
		logger.info("# QueryString    = {}", request.getQueryString());
		logger.info("# ServerName     = {}", request.getServerName());
		logger.info("# RequestURI     = {}", request.getRequestURI());
		logger.info("# ContextPath    = {}", request.getContextPath());
		logger.info("################################################################");

		/**
		 * 세션 확인
		 */
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("USERSESSION");
		if(sessionId == null || "".equals(sessionId)){
			response.sendRedirect("/zTest/login");
			return false;
		}
		
		return true;
	}

	/**
	 * postHandle
	 *
	 * controller 호출 후 view 페이지 출력전
	 */
	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) {
	}

	/**
	 * afterCompletion
	 *
	 * controller + view 페이지 모두 출력 후
	 */
	@Override
	public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) {
	
	}

}
