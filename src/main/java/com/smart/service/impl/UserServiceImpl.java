package com.smart.service.impl;

import com.smart.dao.UserMapper;
import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 占大帅 on 2017/7/9.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public User getUserByUsername(String username) {
        return userMapper.selectUserByName(username);
    }
}
