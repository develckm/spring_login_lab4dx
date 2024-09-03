package com.lab4dx.customer_login.mapper;

import com.lab4dx.customer_login.dto.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderMapper {
    List<Order> findAll();
    List<Order> findByCustomerId(int customerId);
}
