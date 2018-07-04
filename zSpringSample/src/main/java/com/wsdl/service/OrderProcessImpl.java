package com.wsdl.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.wsdl.model.OrderProcess;
import com.wsdl.model.ResRet;
//@org.apache.cxf.interceptor.OutFaultInterceptors (interceptors = {"com.common.CustomFaultInterceptor" })필요시 사용
@WebService(endpointInterface = "com.wsdl.model.OrderProcess")
public class OrderProcessImpl implements OrderProcess{
	
 
 public ResRet processOrder(String user){
  
	 ResRet resRet = new ResRet();
  if(user == null){
	  
   return resRet;
  }else if(user.equals("test")){
	  resRet.setUser("user");
	  resRet.setUser_addr("si");
	  resRet.setUserName("name");
   return resRet;
   
  }else{
	  resRet.setUser("no");
	  resRet.setUser_addr("no");
	  resRet.setUserName("no");
   return resRet;
  }
  

 }
}

