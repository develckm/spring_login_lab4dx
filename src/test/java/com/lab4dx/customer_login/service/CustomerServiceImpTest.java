package com.lab4dx.customer_login.service;

import com.lab4dx.customer_login.dto.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImpTest {
    //test 는 생사자 매개변수 주입 안됨
    @Autowired
    CustomerService customerService;

    @Test
    void login() {
        System.out.println(customerService.login(999,"12345"));
    }

    @Test
    void signup() {
        Customer customer = new Customer();
        customer.setCustomer_id(888);
        customer.setCustomer_name("서비스테스트");
        customer.setCustomer_email("service@test.com");
        customer.setCustomer_phone("12345");
        boolean result = customerService.signup(customer);
        System.out.println(result);
    }

    @Test
    void checkId() {
        boolean result = customerService.checkId(5);
        System.out.println(result);
    }
}