package com.tangcloud.shiro.service;

import com.tangcloud.shiro.domain.User;

public interface UserService {

    User selectUser(User user);

    User selectById(int id);
}
