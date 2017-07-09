package com.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 占大帅 on 2017/7/9.
 */
@Controller
public class IndexController {
    @RequestMapping("/home")
    public String index(){
        System.out.println("登录成功");
        return "home";
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
    @RequestMapping("/error")
    public String error(){
        return "error";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
}
