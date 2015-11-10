package io.github.gefangshuai.server.core.shiro;

import io.github.gefangshuai.business.model.Restaurant;
import io.github.gefangshuai.business.service.RestaurantService;
import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.constant.SessionConstant;
import io.github.gefangshuai.server.core.spring.AppApplicationContext;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
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
        RestaurantService restaurantService = AppApplicationContext.getInstance().getApplicationContext().getBean(RestaurantService.class);
        Restaurant restaurant = restaurantService.findByUsername((String) subject.getPrincipal());
        User user = restaurant.getUser();
        ShiroUser shiroUser = new ShiroUser(true, user.getUsername(), user);
        shiroUser.setRoles(new String[]{user.getRole().getName()});

        Session session = subject.getSession();
        session.setAttribute(SessionConstant.USER_KEY, shiroUser);
        session.setAttribute(SessionConstant.RESTAURANT_KEY, restaurant);

        return super.onLoginSuccess(token, subject, request, response);
    }
}