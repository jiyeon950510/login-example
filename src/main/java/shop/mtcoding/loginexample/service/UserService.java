package shop.mtcoding.loginexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.loginexample.dto.JoinReqDto;
import shop.mtcoding.loginexample.dto.LoginReqDto;
import shop.mtcoding.loginexample.handler.ex.CustomException;
import shop.mtcoding.loginexample.model.User;
import shop.mtcoding.loginexample.model.UserRepository;
import shop.mtcoding.loginexample.util.PasswordHash;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional // insert 할때, 동시에 다른 유저가 들어왔을떄 스레드 대기.()
    public void 회원가입(JoinReqDto joinReqDto) {
        User sameUser = userRepository.findByUsername(joinReqDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다");
        }
        String passwordHash = PasswordHash.getPasswordHash(joinReqDto.getPassword());
        // System.out.println(passwordHash);

        joinReqDto.setPassword(passwordHash);

        int result = userRepository.insert(joinReqDto);
    }

    @Transactional(readOnly = true)
    public User 로그인(LoginReqDto loginReqDto) {
        User principal = userRepository.findByUsernameAndPassword(loginReqDto);
        if (principal == null) {
            throw new CustomException("유저네임 혹은 패스워드가 잘못 입력되었습니다.");
        }
        String passwordHash = PasswordHash.getPasswordHash(loginReqDto.getPassword());
        principal.setPassword(passwordHash);
        // System.out.println("패스워드:" + principal.getPassword());
        return principal;
    }
}
