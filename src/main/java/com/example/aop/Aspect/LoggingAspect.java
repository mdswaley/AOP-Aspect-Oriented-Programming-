package com.example.aop.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.aop.Services.Imp.ShipmentImp.*(..))")
    public void beforeShipmentServiceMethod(JoinPoint jp) {
        log.info("Before method call {}", jp.getSignature());
    }

    @Before("execution(* orderPackage(..))")
    public void beforeAnyOrderPackageCall(){
        log.info("Before any order package call logging.");
    }

    @Before("execution(* com.example.aop.Services.Imp.ShipmentImp.orderPackage(..))")
    public void beforeInShipmentOrderPackageCall(){
        log.info("Before in shipment order package call logging.");
    }

    @Before("execution(* com.example.aop.Services.Imp.*.*(..))")
    public void beforeAnyMethodCall(JoinPoint joinPoint){
        log.info("Before any method call logging kind {}",joinPoint.getKind());
        log.info("Before any method call logging signature {}",joinPoint.getSignature());
    }
}
