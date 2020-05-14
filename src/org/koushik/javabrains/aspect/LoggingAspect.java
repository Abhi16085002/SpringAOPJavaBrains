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

@Aspect
public class LoggingAspect {

//	@Before("allCircleMethods()")  
//	public void loggingAdvice(JoinPoint joinPoint) {
//		System.out.println(joinPoint.toString());
//		System.out.println(joinPoint.getTarget());
//		Circle circle = (Circle) joinPoint.getTarget();
//		System.out.println(circle.getName() + " doooooooooo");
//		
//	}
	
	@AfterReturning(pointcut="args(name)",returning="returnString")
	public void stringArgumentMethod(String name,String returnString ) {
		System.out.println("A method that takes string argument has been called. The value is " + name + ". The output value is " + returnString );
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex" )
	public void exceptionAdvice(String name,Exception ex) {
		System.out.println("An exception has been thrown "+ ex);
	}
	
	@Around("@annotation(org.koushik.javabrains.aspect.Loggable)")
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
	
	@Pointcut("execution(* get*())") 
	public void allGetters () {} 
	
	@Pointcut("within(org.koushik.javabrains.model.Circle)")   
	public void allCircleMethods() {}
	
}
