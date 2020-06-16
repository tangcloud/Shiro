package com.tangcloud.shiro.service.impl;

import com.tangcloud.shiro.domain.User;
import com.tangcloud.shiro.mapper.UserMapper;
import com.tangcloud.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }
}
