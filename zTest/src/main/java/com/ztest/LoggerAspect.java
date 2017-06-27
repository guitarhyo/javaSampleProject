package com.ztest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ztest.controller.BaseController;

@Aspect
public class LoggerAspect {
//http://addio3305.tistory.com/86
	private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	    static String name = "";
	    static String type = "";
	     
	    @Around("execution(* com..controller.*Controller.*(..)) or execution(* com..service.*Impl.*(..)) or execution(* com..dao.*Dao.*(..))")
	    public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
	        type = joinPoint.getSignature().getDeclaringTypeName();
	         
	        if (type.indexOf("Controller") > -1) {
	            name = "Controller  \t:  ";
	        }
	        else if (type.indexOf("Service") > -1) {
	            name = "ServiceImpl  \t:  ";
	        }
	        else if (type.indexOf("Dao") > -1) {
	            name = "Dao  \t\t:  ";
	        }
	        logger.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
	        return joinPoint.proceed();
	    }
}
