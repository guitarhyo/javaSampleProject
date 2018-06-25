package com.wsdl.service;

import javax.jws.WebService;

import com.wsdl.model.OrderProcess;
@org.apache.cxf.interceptor.OutFaultInterceptors (interceptors = {"com.common.CustomFaultInterceptor" })
@WebService(endpointInterface = "com.wsdl.model.OrderProcess")
public class OrderProcessImpl implements OrderProcess{
 @Override
 public String processOrder(String user){
  
  if(user == null){
   return "error";
  }else if(user.equals("aaa")){
   return "test_return1";
  }else{
   return "test_return2";
  }
  

 }
}

