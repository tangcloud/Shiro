package com.tangcloud.shiro.mapper;

import com.tangcloud.shiro.domain.User;

public interface UserMapper {

    User selectUser(User user);

    User selectById(int id);
}
