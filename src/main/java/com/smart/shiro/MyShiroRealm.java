package com.smart.shiro;

import com.smart.domain.Role;
import com.smart.domain.User;
import com.smart.service.PermissionService;
import com.smart.service.RoleService;
import com.smart.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 占大帅 on 2017/7/9.
 */
@Component("myshiroReam")
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    @Qualifier("permissionService")
    private PermissionService permissionService;
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名
        String username=(String) principalCollection.fromRealm(getName()).iterator().next();
        if(username!=null){
            List<String> listUrl=permissionService.getTheUrl(username);//权限
            User user=userService.getUserByUsername(username);//用户信息
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            if(listUrl!=null&&!listUrl.isEmpty()){
                for(String url:listUrl){
                    info.addStringPermission(url);//加入权限
                }
            }
            List<Role> roles=roleService.getRoles(user.getId());
            if(roles!=null&&!roles.isEmpty()){
                for(Role role:roles){
                    info.addRole(role.getName());//加入角色
                }
            }
            return info;
        }
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        //通过表单接收的用户名
        String username=token.getUsername();
        if(username!=null&&!"".equals(username)){
            User user=userService.getUserByUsername(username);
            if(user!=null){
                return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
            }
        }
        return null;
    }
}
