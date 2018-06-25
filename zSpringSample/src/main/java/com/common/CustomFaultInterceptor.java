package com.common;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;


public class CustomFaultInterceptor extends AbstractSoapInterceptor {
	 
	   public CustomFaultInterceptor() {
	     super(Phase.MARSHAL);
	   }
	 
	   public void handleMessage(SoapMessage message) throws Fault {
		
	   }
	   
	  
}
