package com.lab4dx.customer_login.mapper;

import com.lab4dx.customer_login.dto.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
   Product findById(int id);
}
