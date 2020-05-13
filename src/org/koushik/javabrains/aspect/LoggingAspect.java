package org.koushik.javabrains.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allGetters()")
	public void loggingAdvice() {
		System.out.println("Advice run. Get method Called");
	}
	
	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second Advice executed.");
	}
	
	@Pointcut("execution(* get*())")  // .. match zero or more character. one can use package for executing method.
	public void allGetters () {} 
}
