package io.github.gefangshuai.rtat.service;

import io.github.gefangshuai.constant.SessionConstant;
import io.github.gefangshuai.constant.StatusEnum;
import io.github.gefangshuai.exception.ModelPersistentException;
import io.github.gefangshuai.ext.persistence.CoreService;
import io.github.gefangshuai.permission.model.Role;
import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.permission.service.UserService;
import io.github.gefangshuai.rtat.dao.RestaurantDao;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.utils.ImageUtils;
import io.github.gefangshuai.utils.QueryUtils;
import io.github.gefangshuai.utils.StoreUtils;
import org.apache.commons.lang3.StringUtils;

import org.im4java.core.IM4JavaException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/9.
 */
@Service
@Transactional(readOnly = true)
public class RestaurantService extends CoreService<Restaurant, Long> {
    private RestaurantDao restaurantDao;

    @Resource
    public void setRestaurantDao(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        super.coreDao = restaurantDao;
    }

    @Resource
    private UserService userService;

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNotNew())
            throw new ModelPersistentException("the restaurant's ID must be 0 or null!");
        User user = userService.createUser(restaurant.getUser(), Role.RESTAURANT);
        restaurant.setUser(user);
        restaurant.setStatus(StatusEnum.VALID);
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



    public List<Restaurant> findAll() {
        return restaurantDao.findAll();
    }

    public List<Restaurant> findValidAndOpening(String province, String city) {
        if(StringUtils.isNotBlank(province) && StringUtils.isNotBlank(city)){
            return restaurantDao.findByOpeningAndStatusAndProvinceLikeAndCityLike(true, StatusEnum.VALID, QueryUtils.getRightLike(province), QueryUtils.getRightLike(city));
        }
        return restaurantDao.findByOpeningAndStatus(true, StatusEnum.VALID);
    }

    @Transactional
    public void rebuildThumb(String root, String graphicsMagickHome) throws InterruptedException, IOException, IM4JavaException {
        List<Restaurant> restaurants = restaurantDao.findAll();
        for (Restaurant restaurant : restaurants) {
            String path = root + restaurant.getImagePath();
            String target = StoreUtils.getThumbPath(path);
            ImageUtils.compress(graphicsMagickHome, path, target, "300");
            restaurant.setThumbImagePath(StoreUtils.getThumbPath(restaurant.getImagePath()));
            update(restaurant);
        }
    }
}
