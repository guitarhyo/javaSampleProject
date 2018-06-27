package com.wsdl.model;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OrderProcessRequest")
public class  OrderProcessRequest {
	public String user;

	public String getName() {
		return user;
	}

	public void setName(String user) {
		this.user = user;
	}
	
}
