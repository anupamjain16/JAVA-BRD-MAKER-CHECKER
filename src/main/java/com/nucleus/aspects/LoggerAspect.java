package com.nucleus.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	
	private Logger mylogger = Logger.getLogger(getClass().getName());

	// for all persistance method
	@Pointcut(value = "execution(* com.nucleus.persistance*.*(..))")
	private void forgetter() {
	}

	
	@Before("forgetter()")
	public void pojocall(JoinPoint point) {
		mylogger.info(point.getSignature().getName() + " called...");

	}

	// for all controller method
	@Before(value = "execution(* com.nucleus.controller.*.*(..))")
	public void forsetter(JoinPoint point) {
		mylogger.info(point.getSignature().getName() + " called...");

	}

	// for all service method
	@Before(value = "execution(* com.nucleus.service.*.*(..))")
	public void forservice(JoinPoint point) {
		mylogger.info(point.getSignature().getName() + " called...");

	}

}
