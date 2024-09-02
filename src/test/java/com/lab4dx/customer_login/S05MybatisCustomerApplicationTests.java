package com.lab4dx.customer_login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
//mybaits 로 mapper 구현하는 방법
//1. 인터페이스 설계 (@Mapper)
//2. 인터페이스 맵핑되는 sql작성된 xml 생성
//3. 자동으로 Mybatis 컨테이너가 데이터베이스를 접속하는 객체를 구현해준다.
//**자동완성 플러그인!!

@SpringBootTest //Junit으로 단위테스트 중 스프링컨테이너의 객체를 주입받을 수 있다.
class S05MybatisCustomerApplicationTests {
    @Autowired //내가 필요한 객체 주입해줘 (DI)
    DataSource dataSource;
    //단위테스트 : 한개씩 테스를 진행 Junit5 => TDD(테스트를 진행하면서 개발=>오류가 발생을 미연에 방지)
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getConnection());
        //데이베이스에 잘 접속하면 객체가 생성되었을거다.(테스트)
    }

}
