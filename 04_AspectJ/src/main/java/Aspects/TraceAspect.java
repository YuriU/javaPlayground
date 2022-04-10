package Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.util.Arrays;

@Aspect
@Component
public class TraceAspect {
    @Before("execution(* Service.HiByeService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.printf("Before %s\r\n", joinPoint.getSignature().getName());
        System.out.println(Arrays.toString(joinPoint.getArgs()));

    }

    @After("execution(* Service.HiByeService.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.printf("After %s\r\n", joinPoint.getSignature().getName());
        //System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* Service.HiByeService.*(..))",
                    returning = "result" )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.printf("After %s Result is \"%s\"\r\n", joinPoint.getSignature().getName(), result);
    }
}
