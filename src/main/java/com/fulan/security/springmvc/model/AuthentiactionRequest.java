package com.fulan.security.springmvc.model;

import lombok.Data;

@Data
public class AuthentiactionRequest {
    //认证请求参数，账号、密码。。
    private String username;

    private String password;
}
