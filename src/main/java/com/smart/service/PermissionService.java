package com.smart.service;

import com.smart.domain.Permission;

import java.util.List;

/**
 * Created by 占大帅 on 2017/7/9.
 */
public interface PermissionService {
    /**
     * 根据用户id找出该用户所有权限
     * @param userid
     * @return
     */
    List<Permission> getPermissionByUserId(int userid);

    /**
     * 根据用户名字，找出所有权限字段
     * @param username
     * @return
     */
    List<String> getTheUrl(String username);
}
