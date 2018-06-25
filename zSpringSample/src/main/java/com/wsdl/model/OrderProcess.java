package com.wsdl.model;

import javax.jws.WebService;

@WebService
public interface  OrderProcess {
	String processOrder(String user);
}
