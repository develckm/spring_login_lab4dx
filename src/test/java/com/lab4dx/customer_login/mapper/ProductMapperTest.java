package com.lab4dx.customer_login.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductMapperTest {
    @Autowired
    ProductMapper productMapper;
    @Test
    void findById() {
        System.out.println(productMapper.findById(1));
    }
}