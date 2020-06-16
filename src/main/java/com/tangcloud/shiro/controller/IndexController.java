package com.tangcloud.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/getShiro")
    public String getShiro(){
        return "shiro";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

}
