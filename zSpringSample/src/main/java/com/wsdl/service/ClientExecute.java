package com.wsdl.service;

import java.util.Iterator;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wsdl.model.OrderProcess;

public class ClientExecute {

		    public static void main(String args[]) {
		    	// cxf test
		    	ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("classpath:conf/client_bean.xml");

			     OrderProcess client = (OrderProcess)context.getBean("client");
			     
			     String result = client.processOrder("aaa");
			     
			     System.out.println("result:"+result);

		    	
		  // SAAJ - SOAP Client Testing
		    	
		        /*
		            The example below requests from the Web Service at:
		             https://www.w3schools.com/xml/tempconvert.asmx?op=CelsiusToFahrenheit


		            To call other WS, change the parameters below, which are:
		             - the SOAP Endpoint URL (that is, where the service is responding from)
		             - the SOAP Action

		            Also change the contents of the method createSoapEnvelope() in this class. It constructs
		             the inner part of the SOAP envelope that is actually sent.
		         */
//		        String soapEndpointUrl = "https://www.w3schools.com/xml/tempconvert.asmx";
//		        String soapAction = "https://www.w3schools.com/xml/CelsiusToFahrenheit";
		        String soapEndpointUrl = "http://localhost:8080/wsdl/OrderProcess";
		        String soapAction = "";

		        callSoapWebService(soapEndpointUrl, soapAction);
		    }

		    private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
		        SOAPPart soapPart = soapMessage.getSOAPPart();

//		        String myNamespace = "myNamespace";
//		        String myNamespaceURI = "https://www.w3schools.com/xml/";
		        String myNamespace = "wsdl";
		        String myNamespaceURI = "http://model.wsdl.com/";

		        // SOAP Envelope
		        SOAPEnvelope envelope = soapPart.getEnvelope();
		        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

		            /*
		            Constructed SOAP Request Message:
		            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="https://www.w3schools.com/xml/">
		                <SOAP-ENV:Header/>
		                <SOAP-ENV:Body>
		                    <myNamespace:CelsiusToFahrenheit>
		                        <myNamespace:Celsius>100</myNamespace:Celsius>
		                    </myNamespace:CelsiusToFahrenheit>
		                </SOAP-ENV:Body>
		            </SOAP-ENV:Envelope>
		            */

		        // SOAP Body
		        SOAPBody soapBody = envelope.getBody();
		        SOAPElement soapBodyElem = soapBody.addChildElement("processOrder", myNamespace);
		        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("arg0");
		        soapBodyElem1.addTextNode("aaa");
		    }

		    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
		        try {
		            // Create SOAP Connection
		            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		            // Send SOAP Message to SOAP Server
		            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

		            // Print the SOAP Response
		            System.out.println("Response SOAP Message:");
		            soapResponse.writeTo(System.out);
		            System.out.println();
		            System.out.println("Response SOAP Data:");
		            
		            Iterator it = soapResponse.getSOAPBody().getChildElements();
		            while (it.hasNext()) {
		                SOAPBodyElement bodyElement = (SOAPBodyElement) it.next();
		                Iterator it2 = bodyElement.getChildElements();
		                while (it2.hasNext()) {
		                    SOAPElement element2 = (SOAPElement) it2.next();
		                    System.out.println(element2.getValue());
		                    System.out.println(element2.getNodeName());
		                }
		            }
		            

		            soapConnection.close();
		        } catch (Exception e) {
		            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
		            e.printStackTrace();
		        }
		    }

		    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
		        MessageFactory messageFactory = MessageFactory.newInstance();
		        SOAPMessage soapMessage = messageFactory.createMessage();

		        createSoapEnvelope(soapMessage);

		        MimeHeaders headers = soapMessage.getMimeHeaders();
		        headers.addHeader("SOAPAction", soapAction);

		        soapMessage.saveChanges();

		        /* Print the request message, just for debugging purposes */
		        System.out.println("Request SOAP Message:");
		        soapMessage.writeTo(System.out);
		        System.out.println("\n");

		        return soapMessage;
		    }
}
