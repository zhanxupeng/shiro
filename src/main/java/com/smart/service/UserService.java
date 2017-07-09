package com.smart.service;

import com.smart.domain.User;

/**
 * Created by 占大帅 on 2017/7/9.
 */
public interface UserService {
    User getUserByUsername(String username);
}
