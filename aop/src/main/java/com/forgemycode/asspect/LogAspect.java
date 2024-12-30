package com.forgemycode.asspect;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
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
	
	@AfterThrowing(value = "execution(* com.forgemycode.service.*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.log(Level.SEVERE,joinPoint.getSignature()+ " An exception thrown with the help of" +
                " @AfterThrowing which happened due to : "+ex.getMessage());
    }

    @AfterReturning(value = "execution(* com.forgemycode.service.*.*(..))",returning = "retVal")
    public void logStatus(JoinPoint joinPoint,Object retVal) {
        logger.log(Level.INFO,joinPoint.getSignature()+ " Method successfully processed with the status " +
                retVal.toString());
    }


}
