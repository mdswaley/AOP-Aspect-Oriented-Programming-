package com.example.aop.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Before("within(com.example.aop.Services.Imp.*)") // this within is use for call every thing inside package like constructor, getter and setter etc
    public void beforeServiceCall(){
        log.info("Service call inside Imp package.");
    }

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTrackOrderCall(){
        log.info("Track order call using transactional annotation.");
    }

    @Before("@annotation(com.example.aop.Aspect.MyLogging)")
    public void beforeOrderPackageCall(){
        log.info("order package call using custom annotation.");
    }

    @Pointcut("@annotation(com.example.aop.Aspect.MyLogging) && within(com.example.aop.Services.Imp.*)")
    public void myLoggingAndAopMethodPointcut(){
    }

    @Before("myLoggingAndAopMethodPointcut()")
    public void beforeOrderPackageCallPointCut(){
        log.info("Before my logging annotation call.");
    }

    @After("myLoggingAndAopMethodPointcut()")
    public void afterOrderPackageCallPointCut(){
        log.info("after my logging annotation call.");
    }


}
