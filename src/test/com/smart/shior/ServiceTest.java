package com.smart.shior;

import com.smart.domain.Permission;
import com.smart.domain.User;
import com.smart.service.PermissionService;
import com.smart.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 占大帅 on 2017/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {
    @Autowired
    @Qualifier("permissionService")
    private PermissionService permissionService;
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Test
    public void getPermission(){
        List<Permission> permissions=permissionService.getPermissionByUserId(1);
        System.out.println(permissions.size());
    }
    @Test
    public void getUser(){
        User user=userService.getUserByUsername("tom");
        System.out.println(user);
    }

}
