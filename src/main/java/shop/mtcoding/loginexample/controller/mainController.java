package shop.mtcoding.loginexample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.loginexample.handler.ex.CustomException;
import shop.mtcoding.loginexample.interceptor.CustomInterceptor;
import shop.mtcoding.loginexample.model.User;

@Controller
public class mainController {

    @Autowired
    private HttpSession session;

    @GetMapping({ "/", "list" })
    public String listForm() {

        return "main/list";
    }

}
