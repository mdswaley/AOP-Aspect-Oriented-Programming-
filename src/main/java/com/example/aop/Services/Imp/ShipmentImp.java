package com.example.aop.Services.Imp;

import com.example.aop.Aspect.MyLogging;
import com.example.aop.Services.ShipmentService;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ShipmentImp implements ShipmentService {

    @Override
    @MyLogging
    public String orderPackage(Long ordId) {
        try {
            log.info("Processing the order.");
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            log.error("Error occurred while processing the order.");
        }

        return "Successfully package your order with id "+ordId;
    }

    @Override
    @Transactional
    public String trackPackage(Long ordId) {
        log.info("tracking your order.");
        throw new RuntimeException("Error occurred while tracking the order.");
    }
}
