package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.RestaurantService;
import io.github.gefangshuai.server.utils.ModelBeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by gefangshuai on 2015/12/3.
 */
@Controller
@RequestMapping("/rtat")
public class RestaurantController {

    @Resource
    private RestaurantService restaurantService;

    @RequestMapping("/open-status/{status}")
    @ResponseBody
    public boolean changeOpenStatus(@PathVariable  boolean status) {
        Restaurant restaurant = ModelBeanUtils.getCurrentRestaurant();
        restaurant.setOpening(status);
        restaurantService.updateWithSession(restaurant);
        return true;
    }
}
