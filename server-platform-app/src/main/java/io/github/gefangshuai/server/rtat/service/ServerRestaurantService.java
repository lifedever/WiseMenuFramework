package io.github.gefangshuai.server.rtat.service;

import io.github.gefangshuai.constant.SessionConstant;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.RestaurantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
/**
 * Created by gefangshuai on 2016/1/7.
 */
@Service
public class ServerRestaurantService {

    private RestaurantService restaurantService;

    @Transactional
    public void updateWithSession(Restaurant restaurant) {
        restaurantService.update(restaurant);
        updateSession(restaurant);
    }

    /**
     * 刷新session里的数据
     *
     * @param restaurant
     */
    public void updateSession(Restaurant restaurant) {
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SessionConstant.RESTAURANT_KEY, restaurant);
    }
}
