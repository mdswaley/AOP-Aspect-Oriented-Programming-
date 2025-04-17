package com.example.aop.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExecutionTimerCheck {

    @Around("@annotation(com.example.aop.Aspect.ExecutionTimeTrack)")
    public Object checkTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Long start = System.currentTimeMillis();
        Object res = proceedingJoinPoint.proceed();
        Long end = System.currentTimeMillis();

        Long diff = end - start;

        log.info("⏱️ Execution time of {} is {} ms", proceedingJoinPoint.getSignature(), diff);

        return res;
    }
}
