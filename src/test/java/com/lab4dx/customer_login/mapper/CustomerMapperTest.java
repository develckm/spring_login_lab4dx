package com.lab4dx.customer_login.mapper;

import com.lab4dx.customer_login.dto.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerMapperTest {
    @Autowired
    private CustomerMapper customerMapper;


    @Test
    void insert() {
        Customer customer = new Customer();
        customer.setCustomer_id(999);
        customer.setCustomer_name("테스트인간");
        customer.setCustomer_email("test@test.com");
        customer.setCustomer_phone("12345");
        int insert = customerMapper.insert(customer);
        System.out.println(insert);
    }

    @Test
    void findByIdAndPhone() {
        Customer customer = customerMapper.findByIdAndPhone(999, "12345");
        System.out.println(customer); // is not null
        Customer customer2 = customerMapper.findByIdAndPhone(999, "1234"); //비밀번호가 틀리면 로그인 안됨!!
        System.out.println(customer2); // is null 예상

    }

    @Test
    void findById() {
        Customer customer = customerMapper.findById(1);
        System.out.println(customer.toString()); //있으면 중복된 아이디입니다 로그를 출력, 없으면 사용가능한 아이디 입니다.
    }
}