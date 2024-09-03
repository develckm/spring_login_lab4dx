package com.lab4dx.customer_login.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Product {
    //Product table
    //PRODUCT_ID Number
    //PRODUCT_NAME Varchar(100)
    //PRODUCT_PRICE Number
    private int product_id;
    private String product_name;
    private int product_price;
}
