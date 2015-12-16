package io.github.gefangshuai.api.controller;

import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gefangshuai on 2015/12/15.
 */
@RestController
@RequestMapping("/api/restaurant")
public class ApiRestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping
    public List<Restaurant> listRestaurants() {
        return restaurantService.findAll();
    }
}