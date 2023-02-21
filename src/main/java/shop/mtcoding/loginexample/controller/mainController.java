package shop.mtcoding.loginexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

    @GetMapping({ "/", "list" })
    public String listForm() {
        return "main/list";
    }
}
