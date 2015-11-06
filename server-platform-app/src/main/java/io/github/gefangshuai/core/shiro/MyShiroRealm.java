package io.github.gefangshuai.core.shiro;

import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.permission.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Realm
 * Created by gefangshuai on 2015/11/4.
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken credentials = (UsernamePasswordToken) token;
        String username = credentials.getUsername();
        String password = new String((char[]) credentials.getCredentials());
        if (username == null) {
            throw new UnknownAccountException("username not provided");
        }
        User user = userService.checkByUsernameAndPassword(username, password);
        if (user == null) {
            throw new UnknownAccountException("Account does not exist");
        }
        return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add(userService.findByUsername(username).getRole().getName());
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }
}
