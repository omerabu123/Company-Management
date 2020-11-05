package com.companyManagment.service;

import java.util.Set;
import com.companyManagment.beans.Employee;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.companyManagment.beans.Employee;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogService {
	private long startTime=0;
	
	@Before(value = "execution(* com.companyManagment.service..*(..))")
	public void startTime() {
		this.startTime=System.currentTimeMillis();
	}

	@After(value = "execution(* com.companyManagment.service..*(..))")
	public void log(JoinPoint joinPoint) {
		float executionTime=(System.currentTimeMillis()-startTime);
		System.out.println("Method: "+joinPoint.getSignature().getName() +" Took "+ executionTime/1000 + " seconds!");
	}
}
