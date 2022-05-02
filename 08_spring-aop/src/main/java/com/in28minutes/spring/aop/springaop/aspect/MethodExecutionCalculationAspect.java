package com.in28minutes.spring.aop.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    private Logger logger = LoggerFactory.getLogger(MethodExecutionCalculationAspect.class);


    @Around("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object retVal = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        logger.info(" Time Taken by {} is {}", joinPoint, timeTaken);
        return retVal;
    }
}
