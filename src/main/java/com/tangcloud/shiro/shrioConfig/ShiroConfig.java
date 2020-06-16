package com.tangcloud.shiro.shrioConfig;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(getSecurityManager());
        //Shiro 内置管理器 可以实现权限相关的控制
        /**
         * 常用的过滤器
         *      anon: 无须认证(登录) 可以访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用rememberMe (记住我)的功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        System.out.println("====================开始拦截========================");

        /**
         * 首页,登录页不拦截
         */
        filterMap.put("/","anon");
        filterMap.put("/login","anon");
        filterMap.put("/getShiro","authc");
        //需要登录的页面直接跳转到login页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    public SecurityManager getSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(getUserRealm());
        return securityManager;

    }

    @Bean
    public UserRealm getUserRealm(){
        return new UserRealm();
    }



}
