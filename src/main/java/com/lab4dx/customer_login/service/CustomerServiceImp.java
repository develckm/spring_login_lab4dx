package com.lab4dx.customer_login.service;

import com.lab4dx.customer_login.dto.Customer;
import com.lab4dx.customer_login.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {
    //@Autowired //Spring Boot AutoWired 만으로 DI 하는 것을 권장하지 않는다(DI중 type 오류가 자주 발생하서)
    //=> 생성자 매개변수로 작성하는 것을 권장 (==@AutoWired)
    private CustomerMapper customerMapper;
    @Autowired
    public CustomerServiceImp(CustomerMapper customerMapper) {
        //내가(CustomerServiceImp) 객체가 될때 해당 매개변수가 꼭 필요해(강제) == 생성자 매개변수
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer login(int id, String phone) {
        return customerMapper.findByIdAndPhone(id, phone);
    }

    @Override
    public Customer get(int id) {
        return customerMapper.findById(id);
    }

    @Override
    public boolean signup(Customer customer) {
        boolean signup=false;
        int insert=customerMapper.insert(customer);
        if(insert>0) signup=true;
        return signup;
    }

    @Override
    public boolean checkId(int id) {
        boolean checkId=false;

        Customer customer=customerMapper.findById(id);
        if(customer==null){ checkId=true; }
        return checkId;
    }
}
