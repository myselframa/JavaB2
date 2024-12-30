package com.forgemycode.asspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class VehicleStartedAspect {

    private Logger logger = Logger.getLogger(VehicleStartedAspect.class.getName());
	@Before("execution(* com.forgemycode.service.*.*(..)) && args(vehicleStarted,..)")
	public void isVehicleStarted(JoinPoint joinpoint,boolean vehicleStarted)throws Throwable{
		
		if(!vehicleStarted) {
			throw new  RuntimeException("Vehicle not started");
		}
	}
}
