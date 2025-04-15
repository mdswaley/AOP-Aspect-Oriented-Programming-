package com.example.aop.Services.Imp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ShipmentImpTest {

    @Autowired
    private ShipmentImp shipmentImp;

    @Test
    void aopOrderPackaging(){
        String s = shipmentImp.orderPackage(1L);
//        assertEquals("Successfully package your order",res);
        log.info(s);
    }

    @Test
    void aopTrackOrder(){
        String s = shipmentImp.trackPackage(1L);
        log.info(s);
    }

}