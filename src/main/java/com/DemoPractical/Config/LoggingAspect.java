package com.DemoPractical.Config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * AUTHOR::ANITA PRAJAPATI
	 * DATE::29-OCT-2023
	 * PURPOSE:: TO GENRATE LOGS
	 * */
	@Around("execution(* com.DemoPractical.*.*.*(..)))")
	public Object aroundLog(ProceedingJoinPoint j) throws Throwable 
	{
		long startTime = System.currentTimeMillis();
		log.info("  " + j.getSignature().getDeclaringTypeName() + "  :  " + j.getSignature().getName() + " :     START ");
		Object value = j.proceed();
		long endtime = System.currentTimeMillis();
		log.info("  " + j.getSignature().getDeclaringTypeName() + "  :  " + j.getSignature().getName() + " :     END "+"  Time Execution is : " + (endtime-startTime) +"ms");
		return value;
	}
	

}
