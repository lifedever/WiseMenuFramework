package io.github.gefangshuai.server.config.shiro;

import io.github.gefangshuai.constant.SessionConstant;

import io.github.gefangshuai.ext.shiro.ShiroExtConfiguration;
import io.github.gefangshuai.ext.shiro.ShiroExtRealm;
import io.github.gefangshuai.ext.shiro.bean.ShiroExtConfig;
import io.github.gefangshuai.ext.shiro.bean.ShiroUser;
import io.github.gefangshuai.ext.shiro.bean.UserModel;
import io.github.gefangshuai.ext.shiro.filter.ShiroExtFormAuthenticationFilter;
import io.github.gefangshuai.permission.model.Role;
import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.permission.service.UserService;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.RestaurantService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by gefangshuai on 2016/1/5.
 */
@Configuration
public class ShiroConfiguration extends ShiroExtConfiguration implements ApplicationContextAware {
    private Logger logger = Logger.getLogger(ShiroConfiguration.class);
    private ApplicationContext context;

    @Override
    protected ShiroExtConfig shiroExtConfig() {
        return new ShiroExtConfig() {
            @Override
            public ShiroExtRealm getShiroExtRealm() {
                return new ShiroExtRealm() {
                    @Override
                    protected UserModel getUserByUsername(String username) {
                        UserService userService = (UserService) context.getBean("userService");
                        User user = userService.findByUsername(username);
                        return user;
                    }

                    @Override
                    protected Set<String> getRolesByUsername(String username) {
                        Set<String> roles = new HashSet<>();
                        UserService userService = (UserService) context.getBean("userService");
                        roles.add(userService.findByUsername(username).getRole().getName());
                        return roles;
                    }

                    @Override
                    protected Set<String> getPermissionsByUsername(String username) {
                        return null;
                    }
                };
            }

            @Override
            public ShiroExtFormAuthenticationFilter getShiroServerFormAuthenticationFilter() {
                return new ShiroExtFormAuthenticationFilter() {
                    @Override
                    protected void doSomethingOnLoginSuccess(ApplicationContext context, AuthenticationToken token, ShiroUser shiroUser, Subject subject, ServletRequest request, ServletResponse response) {
                        logger.debug("login success!");
                        UserService userService = context.getBean(UserService.class);

                        User user = userService.findByUsername((String) subject.getPrincipal());
                        Session session = subject.getSession();
                        shiroUser.setRoles(new String[]{user.getRole().getName()});
                        if (user.getRole() == Role.RESTAURANT) {
                            RestaurantService restaurantService = context.getBean(RestaurantService.class);
                            Restaurant restaurant = restaurantService.findByUsername((String) subject.getPrincipal());
                            session.setAttribute(SessionConstant.RESTAURANT_KEY, restaurant);
                        }
                    }
                };
            }

            @Override
            public String getLoginUrl() {
                return "/login";
            }

            @Override
            public String getSuccessUrl() {
                return "/";
            }

            @Override
            public String getUnauthorizedUrl() {
                return "/forbidden";
            }

            @Override
            public Map<String, String> getFilterChainDefinitionMap() {
                Map<String, String> filterMap = new HashMap<>();
                filterMap.put("/login", "authc");
                filterMap.put("/logout", "logout");
                filterMap.put("/favicon.ico", "anon");
                filterMap.put("/css/**", "anon");
                filterMap.put("/img/**", "anon");
                filterMap.put("/js/**", "anon");
                filterMap.put("/fonts/**", "anon");
                filterMap.put("/font-awesome/**", "anon");
                filterMap.put("/create", "anon");
                filterMap.put("/account/**", "anon");
                filterMap.put("/api/**", "anon");
                filterMap.put("/rtat/**", "authc,roles[restaurant]");
                filterMap.put("/admin/**", "authc,roles[administrator]");
                return filterMap;
            }
        };
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
