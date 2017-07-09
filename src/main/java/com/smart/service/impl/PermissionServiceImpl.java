package com.smart.service.impl;

import com.smart.dao.PermissionMapper;
import com.smart.dao.RoleMapper;
import com.smart.dao.UserMapper;
import com.smart.domain.Permission;
import com.smart.domain.Role;
import com.smart.domain.User;
import com.smart.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 占大帅 on 2017/7/9.
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    public List<Permission> getPermissionByUserId(int userid) {
        List<Role> list=roleMapper.selectByUserId(userid);
        List<Permission> permissions=new ArrayList<Permission>();
        for(Role role:list){
            List<Permission> permissionList=permissionMapper.selectPermissionByRoleId(role.getId());
            permissions.addAll(permissionList);
        }
        return permissions;
    }

    public List<String> getTheUrl(String username) {
        User user=userMapper.selectUserByName(username);
        List<Permission> permissions=getPermissionByUserId(user.getId());
        List<String> listUrl=new ArrayList<String>();
        for(Permission permission:permissions){
            listUrl.add(permission.getTheurl());
        }
        return listUrl;
    }
}
