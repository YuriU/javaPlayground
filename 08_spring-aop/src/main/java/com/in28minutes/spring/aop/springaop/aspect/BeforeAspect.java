package com.in28minutes.spring.aop.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspect {

    private Logger logger = LoggerFactory.getLogger(BeforeAspect.class);

    @Before("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.allLayersExecution()")
    //@Before("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
    //@Before("execution(* com.in28minutes.spring.aop.springaop..*.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info(" Intecepted Method Calls - {}", joinPoint);
    }
}
