package io.github.gefangshuai.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.model.FoodType;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.FoodService;
import io.github.gefangshuai.rtat.service.FoodTypeService;
import io.github.gefangshuai.rtat.service.RestaurantService;
import io.github.gefangshuai.utils.CustomJsonView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/12/16.
 */
@RestController
@RequestMapping("/api/restaurant/{restaurantId}/food/types")
public class FoodRestController {
    @Resource
    private FoodTypeService foodTypeService;
    @Resource
    private RestaurantService restaurantService;
    @Resource
    private FoodService foodService;

    @ModelAttribute
    private Restaurant getRestaurant(@PathVariable long restaurantId) {
        return restaurantService.findOne(restaurantId);
    }

    @RequestMapping
    @JsonView(CustomJsonView.RestJsonView.class)
    public List<FoodType> listFoodTypes(@ModelAttribute Restaurant restaurant){
        return foodTypeService.findByRestaurant(restaurant);
    }

    @RequestMapping("/{typeId}/foods")
    @JsonView(CustomJsonView.RestJsonView.class)
    public List<Food> listFoods(@ModelAttribute Restaurant restaurant, @PathVariable long typeId) {
        FoodType foodType = foodTypeService.findOne(typeId);
        return foodService.findPublishedByRestaurantAndType(restaurant, foodType);
    }
}
