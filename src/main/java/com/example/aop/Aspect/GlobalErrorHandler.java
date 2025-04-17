package com.example.aop.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
public class GlobalErrorHandler {

    // * -> any return type
    // com.example.aop..* -> any class or subclass in com.example.aop
    // *(..) -> any method name with any parameters.

    @AfterThrowing("execution(* com.example.aop..*(..))")
    public void globalErrorHandlerCheck(JoinPoint joinPoint){
        log.info("got exception in this {} location",joinPoint.getSignature());
    }
}
