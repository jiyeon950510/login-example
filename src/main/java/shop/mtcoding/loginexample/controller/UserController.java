package shop.mtcoding.loginexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("logoutForm")
    public String logout() {
        return "user/loginForm";
    }

    @GetMapping("loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("joinForm")
    public String joinForm() {
        return "user/joinForm";
    }
}
