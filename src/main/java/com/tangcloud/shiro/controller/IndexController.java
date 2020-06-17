package com.tangcloud.shiro.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping("/onAuth")
    public String onAuth(){
        return "onAuth";
    }

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "edit";
    }

}
