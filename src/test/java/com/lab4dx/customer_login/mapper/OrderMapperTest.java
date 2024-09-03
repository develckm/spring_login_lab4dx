package com.lab4dx.customer_login.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderMapperTest {
    @Autowired
    OrderMapper orderMapper;

    @Test
    void findAll() {
        System.out.println(orderMapper.findAll());
    }

    @Test
    void findByCustomerId() {
        System.out.println(orderMapper.findByCustomerId(1));
    }
}