package org.koushik.javabrains.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allGetters() || allCircleMethods()")  // use && for and operation
	public void loggingAdvice() {
		System.out.println("Advice run. Get method Called");
	}
	
	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second Advice executed.");
	}
	
	@Pointcut("execution(* get*())")  // .. match zero or more character. one can use package for executing method.
	public void allGetters () {} 
	
	@Pointcut("within(org.koushik.javabrains.model.Circle)")   // execution(* * org.koushik.javabrains.model.circle.*)
	public void allCircleMethods() {}
	
//	@Pointcut(args(..*)) an example check spring site
}
