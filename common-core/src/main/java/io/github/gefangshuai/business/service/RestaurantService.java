package io.github.gefangshuai.business.service;

import io.github.gefangshuai.business.dao.RestaurantDao;
import io.github.gefangshuai.business.model.Restaurant;
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

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return restaurantDao.save(restaurant);
    }
}
