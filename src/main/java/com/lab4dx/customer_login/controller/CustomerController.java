package com.lab4dx.customer_login.controller;

import com.lab4dx.customer_login.dto.Customer;
import com.lab4dx.customer_login.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
            RedirectAttributes redirectAttributes
            ) { //input의 name과 dto의 필드명이 같으면 자동으로 파싱된다.
        //redirect : 서버에서 다른페이지를 호출 302
        boolean sigup=false;
        System.out.println(customer);
        try {
            sigup=customerService.signup(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(!sigup){
            //**redirect 페이지는 다른 페이지로 이동하기 때문에 Model 로 데이터를 전달할 수 없다.

            //1. 파라미터로 전달. redirectAttributes.addAttribute
            //2. session으로 전달.
            //3. session인데 다음페이지까지만 사용되는 데이터 사용
            //redirectAttributes.addFlashAttribute
            redirectAttributes.addFlashAttribute("msg","회원가입실패");
            return "redirect:/customer/signup.do"; //get 방식으로 호출(회원가입 뷰)
        }else{
            redirectAttributes.addFlashAttribute("msg","회원가입성공");

            return "redirect:/";
        }
    }
    @PostMapping("/login.do")
    public String loginAction(
            int id,
            String phone,
            RedirectAttributes redirectAttributes,
            HttpSession session
    ){
        Customer customer=customerService.login(id, phone);
        if(customer!=null){
            session.setAttribute("customer",customer);
            redirectAttributes.addFlashAttribute("msg","로그인 성공");
            return "redirect:/"; //로그인 성공시 홈
        }else {
            redirectAttributes.addFlashAttribute("msg","아이디나 비밀번호를 확인하세요.");
            return "redirect:/customer/login.do";//실패시 다시 로그인 폼
        }
    }
    @GetMapping("/logout.do")
    public String logoutAction(HttpSession session) {
        session.removeAttribute("customer"); //서버에 저장된 세션 객체 삭제
       //session.invalidate(); //서버에 저장된 모든 세션을 삭제
        //개발도중 서버가 재시작되면 세션이 삭제된다.
        return "redirect:/";
    }
    //view가 없이 문자열만 응답 -> 이런동적페이지 ResponsBody
    @GetMapping("/checkId.do")
    @ResponseBody
    public Map checkId(int id) {
        boolean check=customerService.checkId(id);
        //json == Map
        Map<String,Boolean> m=new HashMap<>();
        m.put("checkId",check);
        return m;
    }

}
