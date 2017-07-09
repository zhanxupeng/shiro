package com.smart.controller;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by 占大帅 on 2017/7/9.
 */
@Controller
public class LoginController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    //跳转到登录页面
    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }
    //实现用户登录
    @RequestMapping(value = "/login")
    public ModelAndView Login(String username,String password){
        ModelAndView mav=new ModelAndView();
        User user=userService.getUserByUsername(username);
        if(user==null){
            mav.setViewName("toLogin");
            mav.addObject("msg","用户不存在");
        }
        if(!user.getPassword().equals(password)){
            mav.setViewName("toLogin");
            mav.addObject("msg","账号密码错误");
            return mav;
        }
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//如果原来有的话，就退出
        //登录后存放进shiro token
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        Subject subject=SecurityUtils.getSubject();
        subject.login(token);
        //登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接
        mav.setViewName("redirect:/success");
        return mav;
    }
    @RequestMapping(value = "logout")
    public String logout(){
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//退出
        return "login";
    }
}
