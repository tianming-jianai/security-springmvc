package com.fulan.security.springmvc.controller;

import com.fulan.security.springmvc.model.AuthentiactionRequest;
import com.fulan.security.springmvc.model.UserDto;
import com.fulan.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login", produces = "text/plain;charset=utf-8")//text/plain;表示文本类型
    public String login(AuthentiactionRequest authentiactionRequest, HttpSession session) {
        UserDto userDto = authenticationService.authentication(authentiactionRequest);
        //存入session
        session.setAttribute(UserDto.SESSION_USER_KEY, userDto);
        return userDto.getUsername() + "登录成功";
    }

    @RequestMapping(value = "/r/r1", produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession session) {
        String fullname = null;
        Object obj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (obj == null) {
            fullname = "匿名";
        } else {
            UserDto userDto = (UserDto) obj;
            fullname = userDto.getFullname();
        }
        return fullname + "访问资源r1";
    }

    @RequestMapping(value = "/logout", produces = {"text/plain;charset=utf-8"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "登出";
    }

}
