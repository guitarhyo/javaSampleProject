package com.sp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.wsdl.extensions.soap.SOAPBody;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class CommonController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;
	
	@RequestMapping(value = "/test/json")
	public @ResponseBody ObjectNode jsonreturn() throws Exception {
		 ObjectMapper objectMapper = new ObjectMapper();
		 ObjectNode node = objectMapper.createObjectNode();
		
	
		
		
		return node;
	}

	
}
