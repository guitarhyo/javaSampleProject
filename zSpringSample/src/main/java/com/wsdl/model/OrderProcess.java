package com.wsdl.model;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface  OrderProcess {
	String processOrder(@WebParam(name = "tcms")String user);
}
