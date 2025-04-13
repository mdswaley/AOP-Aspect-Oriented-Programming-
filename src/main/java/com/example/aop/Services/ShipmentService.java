package com.example.aop.Services;

public interface ShipmentService {
    String orderPackage(Long ordId);
    String trackPackage(Long ordId);
}
