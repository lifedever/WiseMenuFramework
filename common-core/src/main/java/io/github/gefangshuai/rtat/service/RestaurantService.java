package io.github.gefangshuai.rtat.service;

import io.github.gefangshuai.rtat.dao.RestaurantDao;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.constant.SessionConstant;
import io.github.gefangshuai.exception.ModelPersistentException;
import io.github.gefangshuai.permission.model.Role;
import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.permission.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by gefangshuai on 2015/11/9.
 */
@Service
@Transactional(readOnly = true)
public class RestaurantService {
    @Resource
    private RestaurantDao restaurantDao;
    @Resource
    private UserService userService;

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNotNew())
            throw new ModelPersistentException("the restaurant's ID must be 0 or null!");
        User user = userService.createUser(restaurant.getUser(), Role.RESTAURANT);
        restaurant.setUser(user);
        return restaurantDao.save(restaurant);
    }

    public Restaurant findByUsername(String username) {
        return restaurantDao.findByUsername(username);
    }

    public Restaurant findOne(long id) {
        return restaurantDao.findOne(id);
    }

    @Transactional
    public void update(Restaurant restaurant) {
        if (StringUtils.isBlank(restaurant.getProvince())) {
            restaurant.setCity(null);
            restaurant.setDistrict(null);
        }
        restaurantDao.save(restaurant);
    }

    /**
     * 刷新session里的数据
     * @param restaurant
     */
    public void updateSession(Restaurant restaurant) {
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SessionConstant.RESTAURANT_KEY, restaurant);
    }

}