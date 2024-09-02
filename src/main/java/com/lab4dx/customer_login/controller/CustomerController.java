package com.lab4dx.customer_login.controller;

import com.lab4dx.customer_login.dto.Customer;
import com.lab4dx.customer_login.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

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
    public String signupAction(
            Customer customer,
            RedirectAttributes redirectAttributes) { //input의 name과 dto의 필드명이 같으면 자동으로 파싱된다.
        //redirect : 서버에서 다른페이지를 호출 302
        boolean sigup=false;
        System.out.println(customer);
        try {
            sigup=customerService.signup(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(!sigup){
            redirectAttributes.addFlashAttribute("msg", "회원가입실패 다시 시도하세요.");
            return "redirect:/customer/signup.do"; //get 방식으로 호출(회원가입 뷰)
        }else{
            redirectAttributes.addFlashAttribute("msg", "회원가입성공 로그인하세요!");
            return "redirect:/";
        }
    }
    @PostMapping("/login.do")
    public String login(
            int id,
            String phone,
            RedirectAttributes redirectAttributes,
            HttpSession session
    ) {

        Customer customer=customerService.login(id, phone);

        if(customer==null){
            redirectAttributes.addFlashAttribute("msg", "로그인 실패 다시 시도하세요.");
            return "redirect:/customer/login.do";
        }else{
            session.setAttribute("customer", customer);
            redirectAttributes.addFlashAttribute("msg", "로그인 성공");
            return "redirect:/";
        }
    }
    @GetMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        //session.removeAttribute("customer");
        return "redirect:/";
    }
    @GetMapping("/checkId.do")
    @ResponseBody
    public Map checkId( int id) {
        HashMap<String,Boolean> map=new HashMap<>();
        map.put("checkId",customerService.checkId(id));
        return map;
    }

}
