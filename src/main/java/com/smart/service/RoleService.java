package com.smart.service;

import com.smart.domain.Role;

import java.util.List;

/**
 * Created by 占大帅 on 2017/7/9.
 */
public interface RoleService {
    /**
     * 根据用户id找出用户所有角色
     * @param userid
     * @return
     */
    List<Role> getRoles(int userid);
}
