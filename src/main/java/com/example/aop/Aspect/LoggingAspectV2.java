package com.example.aop.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2 {

    @Pointcut("execution(* com.example.aop.Services.Imp.*.*(..))")
    public void allServiceMethodPointcut(){}

    @Before("allServiceMethodPointcut()")
    public void beforeServiceMethodCall(JoinPoint jp){
        log.info("Before advice method call {}",jp.getSignature());
    }

    @After("allServiceMethodPointcut()")
    public void afterServiceMethodCall(JoinPoint jp){
        log.info("after all service method call {}",jp.getSignature().getName());
    }

    @AfterReturning(value = "allServiceMethodPointcut()",returning = "returnObj")
    public void afterReturningServiceMethodCall(JoinPoint jp,Object returnObj){
        log.info("after returning service method call {} , {}",jp.getSignature(),returnObj);
    }
}
