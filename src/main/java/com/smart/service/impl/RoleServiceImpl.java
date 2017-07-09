package com.smart.service.impl;

import com.smart.dao.RoleMapper;
import com.smart.domain.Role;
import com.smart.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 占大帅 on 2017/7/9.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public List<Role> getRoles(int userid) {
        return roleMapper.selectByUserId(userid);
    }
}
