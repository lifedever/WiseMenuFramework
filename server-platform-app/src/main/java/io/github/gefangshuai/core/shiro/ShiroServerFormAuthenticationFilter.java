package io.github.gefangshuai.core.shiro;

import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.permission.service.UserService;
import io.github.gefangshuai.core.spring.AppApplicationContext;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * shiro登录权限验证过滤器
 */
public class ShiroServerFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        UserService userService = AppApplicationContext.getInstance().getApplicationContext().getBean(UserService.class);
        User user = userService.findByUsername((String) subject.getPrincipal());
        ShiroUser shiroUser = new ShiroUser(true, user.getUsername(), user);
        shiroUser.setRoles(new String[]{user.getRole().getName()});
        subject.getSession().setAttribute("shiroUser", shiroUser);
        return super.onLoginSuccess(token, subject, request, response);
    }
}