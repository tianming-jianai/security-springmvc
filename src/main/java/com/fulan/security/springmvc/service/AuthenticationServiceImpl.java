package com.fulan.security.springmvc.service;

import com.fulan.security.springmvc.model.AuthentiactionRequest;
import com.fulan.security.springmvc.model.UserDto;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationServiceImpl implements AuthenticationService {
    //用户信息
    private Map<String, UserDto> userMap = new HashMap<>();

    {
        userMap.put("zhangsan", new UserDto("1001", "zhangsan", "m123", "axjl zhangsan", "18438888888"));
        userMap.put("lisi", new UserDto("1002", "lisi", "m123", "axjl lisi", "18436666666"));
    }

    /**
     * 用户认证
     *
     * @param authentication 用户认证请求 账号和密码
     * @return 认证成功的用户信息
     */
    @Override
    public UserDto authentication(AuthentiactionRequest authentiactionRequest) {
        if (authentiactionRequest == null
                || StringUtils.isEmpty(authentiactionRequest.getUsername())
                || StringUtils.isEmpty(authentiactionRequest.getPassword())) {
            throw new RuntimeException("用户名或密码为空");
        }
        //根据账号去查数据库，这里模拟数据库查询
        UserDto userDto = getUserDto(authentiactionRequest.getUsername());
        //判断用户是否为空
        if (userDto == null) {
            throw new RuntimeException("查询不到该用户");
        }
        if (!authentiactionRequest.getPassword().equals(userDto.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }
        //认证通过，返回用户身份信息
        return userDto;
    }

    //根据账号获取用户信息
    private UserDto getUserDto(String username) {
        return userMap.get(username);
    }

}
