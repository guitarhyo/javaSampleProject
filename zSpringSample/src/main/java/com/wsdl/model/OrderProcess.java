package com.wsdl.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService
public interface  OrderProcess {
	
	@WebMethod(operationName="test1")
	 @RequestWrapper(localName="test123")
	 @ResponseWrapper(localName="test1234")
	@WebResult(name = "tempResult")ResRet processOrder(@WebParam(name = "tempName")String user);
}
