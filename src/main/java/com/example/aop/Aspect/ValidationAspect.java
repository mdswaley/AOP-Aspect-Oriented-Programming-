package com.example.aop.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
public class ValidationAspect {

    @Pointcut("execution(* com.example.aop.Services.Imp.*.*(..))")
    public void allServiceMethodPointcut(){}

    @Around("allServiceMethodPointcut()")
    public Object validateOrderId(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object args[] = proceedingJoinPoint.getArgs(); // value of argument pass in method which is orderId of long type.

        Long orderId = (Long) args[0]; // suppose fun(int a,String b) then args[0] = a and args[1] = b

        if(orderId > 0) return proceedingJoinPoint.proceed();

        return "cannot proceed with negative value.";
    }

    @Around("allServiceMethodPointcut()")
    public Object timeTakenEachMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long start = System.currentTimeMillis();
        Object returnTime = proceedingJoinPoint.proceed();
        Long end = System.currentTimeMillis();

        Long diff = end - start;

        log.info("Difference between method execution in {} is {}",proceedingJoinPoint.getSignature(),diff);

        return returnTime;
    }
}
