package com.fulan.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    public static final String SESSION_USER_KEY = "_user";
    //用户身份信息
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
