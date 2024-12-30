package com.forgemycode.asspect;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	private Logger logger = Logger.getLogger(LogAspect.class.getName());
	@Around("execution(* com.forgemycode.service.*.*(..))")
	public void printLogger(ProceedingJoinPoint proccedingJoinPoint) throws Throwable {
        logger.info(proccedingJoinPoint.getSignature().toString() + " method execution start");
		Instant start = Instant.now();
        logger.info("method execution start");
		
		
        proccedingJoinPoint.proceed();
        
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
	    
	     
	}

}
