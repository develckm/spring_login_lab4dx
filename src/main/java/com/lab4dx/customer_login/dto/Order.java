package com.lab4dx.customer_login.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter@Setter@ToString
public class Order {
    //table Orders
    //ORDER_ID Number pk
    //CUSTOMER_ID Number fk(Customer.CUSTOMER_ID)
    //PRODUCT_ID Number fk(Product.PRODUCT_ID)
    //QUANTITY Number
    //ORDER_DATE Date default
    private int order_id;
    private int quantity;
    private Date order_date;

    private int customer_id;
    //private Customer customer; //N:1 join
    //Customer -> Orders -> Customor->Orders -> ......g.StackOverflowError

    private int product_id;
    private Product product; //N:1 join
}
