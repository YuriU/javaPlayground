package com.in28minutes.spring.aop.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

    private Logger logger = LoggerFactory.getLogger(AfterAspect.class);

    @AfterReturning(
            value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info(" {} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(
            value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info(" {} returned thrown {}", joinPoint, exception);
    }

    @After("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info(" After {}", joinPoint);
    }
}
