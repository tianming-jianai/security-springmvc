package com.fulan.security.springmvc.service;

import com.fulan.security.springmvc.model.AuthentiactionRequest;
import com.fulan.security.springmvc.model.UserDto;

public interface AuthenticationService {
    /**
     * 用户认证
     *
     * @param authentication 用户认证请求
     * @return 认证成功的信息
     */
    UserDto authentication(AuthentiactionRequest authentiactionRequest);
}
