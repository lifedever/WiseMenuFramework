package io.github.gefangshuai.server.utils;

import io.github.gefangshuai.constant.SessionConstant;
import io.github.gefangshuai.rtat.model.Restaurant;
import org.apache.shiro.SecurityUtils;

/**
 * 获取对象有关的工具类
 * Created by gefangshuai on 2015/12/1.
 */
public class ModelBeanUtils {
    /**
     * 获取当前登录用户所属的Restaurant
     * @return
     */
    public static Restaurant getCurrentRestaurant() {
        Restaurant restaurant = (Restaurant) SecurityUtils.getSubject().getSession().getAttribute(SessionConstant.RESTAURANT_KEY);
        return restaurant;
    }
}
