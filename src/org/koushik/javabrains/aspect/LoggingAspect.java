package org.koushik.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.koushik.javabrains.model.Circle;

public class LoggingAspect {

	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint ) {
		
		Object returnValue = null;
		
		try {
			
			System.out.println("Before Around");
			returnValue = proceedingJoinPoint.proceed(); // we can skip the target method entirely
			System.out.println("After Around");
			
		} catch (Throwable e) {
			System.out.println("After Throwing");
		} 
		
		System.out.println("After Finally");
		return returnValue;
	}
	
	public void loggingAdvice() {
		System.out.println("logging from Advice");
	}
	
}
