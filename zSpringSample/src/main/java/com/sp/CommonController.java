package com.sp;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class CommonController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;
	
	@RequestMapping(value = "/test/json")
	public @ResponseBody ObjectNode jsonreturn(@RequestBody ObjectNode node) throws Exception {
//		 ObjectMapper objectMapper = new ObjectMapper();
//		 ObjectNode node = objectMapper.createObjectNode();
		 
		 System.out.println(node.toString());
		System.out.println("--------------------");
		 String queryString = request.getQueryString();
		 System.out.println(queryString);
		 
		 Enumeration params = request.getParameterNames();
		 System.out.println("----------------------------");
		 while (params.hasMoreElements()){
		     String name = (String)params.nextElement();
		     System.out.println(name + " : " +request.getParameter(name));
		 }


		 node.put("test", "1234");
		 node.put("test2", "테스트");
		return node;
	}

	
}
