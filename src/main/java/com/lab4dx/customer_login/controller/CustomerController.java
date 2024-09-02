package com.lab4dx.customer_login.controller;

import com.lab4dx.customer_login.dto.Customer;
import com.lab4dx.customer_login.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login.do")
    public void login() {}
    @GetMapping("/signup.do")
    public void signup() {}
    //action page : 데이터를 처리만 하는 페이지
    @PostMapping("/signup.do")
    public String signupAction(Customer customer) { //input의 name과 dto의 필드명이 같으면 자동으로 파싱된다.
        //redirect : 서버에서 다른페이지를 호출 302
        boolean sigup=false;
        System.out.println(customer);
        try {
            sigup=customerService.signup(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(!sigup){
            return "redirect:/customer/signup.do"; //get 방식으로 호출(회원가입 뷰)
        }else{
            return "redirect:/";
        }

    }
}
