package com.confirm.confirm.service;


import com.confirm.confirm.dto.Login;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public Cookie login(Login loginData) {
        // 이 코드는 빌드를 깨지 않기 위한 stub 코드임. 추후 구현이 필요함.
        Cookie cookie = new Cookie("session", "loginCookie");
        cookie.setMaxAge(60*60);

        return cookie;
    }

}
