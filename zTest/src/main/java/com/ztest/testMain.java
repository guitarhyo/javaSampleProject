package com.ztest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.ztest.vo.Team;

public class testMain {

public static void main(String[] args) {

	
	//testAnnotaion
	Team team = new Team();
	 try {
		Method  method = team.getClass().getDeclaredMethod("hello");
		
		if(method.isAnnotationPresent(testAnnotaion.class)){
			for (int i = 0; i < 10; i++) {
				team.hello();
			}
			
		}
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	


}
