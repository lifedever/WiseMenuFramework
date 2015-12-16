package io.github.gefangshuai.server.core.shiro;

import io.github.gefangshuai.permission.model.Role;
import io.github.gefangshuai.permission.service.UserService;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.RestaurantService;
import io.github.gefangshuai.constant.SessionConstant;
import io.github.gefangshuai.permission.model.User;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * shiro登录权限验证过滤器
 */
public class ShiroServerFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext((request.getServletContext()));
        UserService userService = context.getBean(UserService.class);

        User user = userService.findByUsername((String) subject.getPrincipal());
        Session session = subject.getSession();

        ShiroUser shiroUser = new ShiroUser(true, user.getUsername(), user);
        shiroUser.setRoles(new String[]{user.getRole().getName()});
        if (user.getRole() == Role.RESTAURANT) {
            RestaurantService restaurantService = context.getBean(RestaurantService.class);
            Restaurant restaurant = restaurantService.findByUsername((String) subject.getPrincipal());
            session.setAttribute(SessionConstant.RESTAURANT_KEY, restaurant);
        }
        session.setAttribute(SessionConstant.USER_KEY, shiroUser);

        return super.onLoginSuccess(token, subject, request, response);
    }
}