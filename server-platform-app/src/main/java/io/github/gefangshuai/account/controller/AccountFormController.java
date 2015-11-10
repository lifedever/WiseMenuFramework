package io.github.gefangshuai.account.controller;

import io.github.gefangshuai.business.model.Restaurant;
import io.github.gefangshuai.business.service.RestaurantService;
import io.github.gefangshuai.constant.ResultCode;
import io.github.gefangshuai.core.context.AppConfig;
import io.github.gefangshuai.utils.StoreUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by gefangshuai on 2015/11/10.
 */
@Controller
@RequestMapping("/account")
public class AccountFormController {
    @Resource
    private RestaurantService restaurantService;
    @Resource
    private AppConfig appConfig;

    @ModelAttribute("restaurant")
    public Restaurant bindRestaurant(@PathVariable long id) {
        Restaurant restaurant;
        if (id > 0) {
            restaurant = restaurantService.findOne(id);
        } else {
            restaurant = new Restaurant();
        }
        return restaurant;
    }

    @ResponseBody
    @RequestMapping(value = "restaurant/{id}/save", method = RequestMethod.POST)
    public ResultCode saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, MultipartFile file) {

        if (file != null) {
            try {
                String relativePath = StoreUtils.storeFile(appConfig.getStorePath(), StoreUtils.getExtension(file.getOriginalFilename()), file.getInputStream());
                restaurant.setImagePath(relativePath);
            } catch (IOException e) {
                e.printStackTrace();
                return ResultCode.Faild;
            }
        }
        restaurantService.update(restaurant);
        return ResultCode.OK;
    }
}
