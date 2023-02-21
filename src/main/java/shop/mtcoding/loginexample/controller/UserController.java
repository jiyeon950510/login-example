package shop.mtcoding.loginexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.loginexample.dto.JoinReqDto;
import shop.mtcoding.loginexample.handler.ex.CustomException;
import shop.mtcoding.loginexample.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) {

        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            throw new CustomException("Username을 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            throw new CustomException("Password을 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        if (joinReqDto.getEmail() == null || joinReqDto.getEmail().isEmpty()) {
            throw new CustomException("Fullname 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        userService.회원가입(joinReqDto);
        return "redirect:/loginForm";
    }

    @GetMapping("/logout")
    public String logout() {
        // session.invalidate();
        return "redirect:/";
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
