package io.github.gefangshuai.business.service;

import io.github.gefangshuai.business.dao.RestaurantDao;
import io.github.gefangshuai.business.model.Restaurant;
import io.github.gefangshuai.permission.model.Role;
import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.permission.service.UserService;
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
        User user = userService.createUser(restaurant.getUser(), Role.RESTAURANT);
        restaurant.setUser(user);
        return restaurantDao.save(restaurant);
    }

    public Restaurant findByUsername(String username) {
        return restaurantDao.findByUsername(username);
    }
}
