package com.lab4dx.customer_login.service;

import com.lab4dx.customer_login.dto.Customer;
import org.springframework.stereotype.Service;

@Service //@Component : 스프링 컨테이너에서 생성되고 주입되는 객체
//Service : 함수에 @Transactional 을 선언하면 자동으로 오류시 rollback 해준다. (ProductServiceImp.resgist 코드 참조)
public interface CustomerService {
    //Customer login(id,phone) 로그인 성공시 Customer,
    //boolean signup(Customer) 회원가입성공시 true,
    //boolean checkId(id) 아이디가 사용가능하면 true
    Customer login(int id, String phone);
    boolean signup(Customer customer);
    boolean checkId(int id);
}
