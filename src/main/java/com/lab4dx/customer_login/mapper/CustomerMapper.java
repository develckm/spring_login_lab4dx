package com.lab4dx.customer_login.mapper;

import com.lab4dx.customer_login.dto.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    //회원가입(insert),로그인(select(id,phone)),아이디중복확인(select(id))
    int insert(Customer customer);
    Customer findByIdAndPhone(int id,String phone);
    Customer findById(int id);

}
