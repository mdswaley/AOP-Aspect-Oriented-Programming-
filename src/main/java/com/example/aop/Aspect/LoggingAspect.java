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
}
