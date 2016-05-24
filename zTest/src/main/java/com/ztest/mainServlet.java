package com.ztest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class mainServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * 작성하시오
		 */
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher.jsp");
	      request.setAttribute("params","Hello World!! dispatcher");
	     dispatcher.forward(request, response);
	}
public static void main(String[] args) {
	
//	String jungbuk = "684951921";
//	System.out.println(jungbuk);
//	boolean jungbukCheck = true;
//	jungbukCheck = true;
//	LOOP1 : for (int l = 0; l < jungbuk.length(); l++) {
//		String cNum = jungbuk.substring(l,l+1);
//		
//		int checkNum = 0 ;
//		for (int num = 1; num < 10; num++) {
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@"+checkNum);
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@"+num);
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@"+cNum);
//			if(cNum.equals(String.valueOf(num))){//왜비교를 못하니
//				checkNum++;
//			}
//
//			
//			if(checkNum > 1){
//				jungbukCheck = false;
//				break LOOP1;
//			}
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
//		}
//
//	}
//	
//
//		System.out.println(jungbukCheck);
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
//
//}
	
	String jungbuk = "684951921";
    jungbuk = "135792468";
    System.out.println(jungbuk);
    boolean jungbukCheck = true;
    jungbukCheck = true;
    LOOP1 : for (int l = 0; l < jungbuk.length()-1; l++) {
       char cNum = jungbuk.charAt(l);
       int checkNum = 0 ;
       for (int num = l+1; num < jungbuk.length(); num++) {
         char dupNum = jungbuk.charAt(num);
          if(cNum == dupNum){
             checkNum++;
          }
          if(checkNum > 0){
             jungbukCheck = false;
             break LOOP1;
          }
       }
    }
    

     System.out.println(jungbukCheck);
}

}