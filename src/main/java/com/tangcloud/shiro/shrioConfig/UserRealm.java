package com.tangcloud.shiro.shrioConfig;

import com.tangcloud.shiro.domain.User;
import com.tangcloud.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源授权字符窜
        //info.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        //动态获取数据库授权字符串
        User user = (User) subject.getPrincipal();
        User dbUser = userService.selectById(user.getId());
        info.addStringPermission(dbUser.getPerms());
        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = new User();
        user.setUserName(token.getUsername());
        user = userService.selectUser(user);

        if(user == null){
            //shiro底层会抛出 UnknownAccountException 用户名不存在
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
