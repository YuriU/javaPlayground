package Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceAspect {
    @Before("execution(* Service.HiByeService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.printf("Before %s\r\n", joinPoint.getSignature().getName());
    }
}
