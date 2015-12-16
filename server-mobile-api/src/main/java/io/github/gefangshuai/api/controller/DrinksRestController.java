package io.github.gefangshuai.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.gefangshuai.rtat.model.Drinks;
import io.github.gefangshuai.rtat.model.DrinksType;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.DrinksService;
import io.github.gefangshuai.rtat.service.DrinksTypeService;
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
@RequestMapping("/api/restaurant/{restaurantId}/drinks/types")
public class DrinksRestController {
    @Resource
    private DrinksTypeService drinksTypeService;
    @Resource
    private RestaurantService restaurantService;
    @Resource
    private DrinksService drinksService;

    @ModelAttribute
    private Restaurant getRestaurant(@PathVariable long restaurantId) {
        return restaurantService.findOne(restaurantId);
    }

    @RequestMapping
    public List<DrinksType> listDrinksTypes(@ModelAttribute Restaurant restaurant){
        return drinksTypeService.findByRestaurant(restaurant);
    }

    @RequestMapping("/{typeId}/drinks")
    @JsonView(CustomJsonView.RestJsonView.class)
    public List<Drinks> listDrinks(@ModelAttribute Restaurant restaurant, @PathVariable long typeId) {
        DrinksType drinksType = drinksTypeService.findOne(typeId);
        return drinksService.findPublishedByRestaurantAndType(restaurant, drinksType);
    }
}
