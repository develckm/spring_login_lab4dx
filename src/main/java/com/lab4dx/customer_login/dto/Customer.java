package com.lab4dx.customer_login.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter@Setter@ToString
public class Customer {
    /*
    Table CUSTOMER
    CUSTOMER_ID Number
    CUSTOMER_NAME Varchar(100)
    CUSTOMER_EMAIL Varchar(100)
    CUSTOMER_PHONE Varchar(20)*/
    private int customer_id;
    private String customer_name;
    private String customer_email;
    private String customer_phone;

    //주문 : 유저 = N : 1
    //유저 : 주문 = 1 : N
    private List<Order> orders;

}
