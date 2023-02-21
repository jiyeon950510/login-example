package shop.mtcoding.loginexample.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.loginexample.model.User;
import shop.mtcoding.loginexample.model.UserRepository;

@MybatisTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    // findByUsernameAndPassword

    @Test
    public void findAllWithUser_test() throws Exception {
        // given
        ObjectMapper om = new ObjectMapper(); // Jackson

        // when
        List<User> user = userRepository.findAll();
        String responseBody = om.writeValueAsString(user);
        System.out.println("테스트 : " + responseBody);

        // then
        assertThat(user.get(0).getUsername()).isEqualTo("ssar");
        assertThat(user.get(1).getUsername()).isEqualTo("cos");
    }
}
