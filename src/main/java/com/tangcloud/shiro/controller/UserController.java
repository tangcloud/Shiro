package com.tangcloud.shiro.controller;

import com.tangcloud.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login(String userName, String password, ModelMap mmap){

        /**
         * 使用Shiro编写认证操作
         */
        //1. 获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2. 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        //3. 执行登录方法
        try{
            //登录成功
            subject.login(token);
            return "shiro";
        }catch (UnknownAccountException e){
            //UnknownAccountException 用户名不存在
            mmap.put("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            mmap.put("msg","密码错误");
            return "login";
        }
    }

}
