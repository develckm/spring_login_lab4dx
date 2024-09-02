package com.lab4dx.customer_login.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

}
