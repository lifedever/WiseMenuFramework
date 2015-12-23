package io.github.gefangshuai.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.gefangshuai.api.core.AppConfigContext;
import io.github.gefangshuai.rtat.model.Drinks;
import io.github.gefangshuai.rtat.model.DrinksType;
import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.DrinksService;
import io.github.gefangshuai.rtat.service.DrinksTypeService;
import io.github.gefangshuai.rtat.service.RestaurantService;
import io.github.gefangshuai.utils.CustomJsonView;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by gefangshuai on 2015/12/16.
 */
@RestController
@RequestMapping("/api/restaurant/{restaurantId}/drinks/types")
public class DrinksTypeRestController {
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
    @JsonView(CustomJsonView.RestJsonView.class)
    public List<DrinksType> listDrinksTypes(@ModelAttribute Restaurant restaurant){
        return drinksTypeService.findByRestaurant(restaurant);
    }

    @RequestMapping("/{typeId}/drinks")
    @JsonView(CustomJsonView.RestJsonView.class)
    public List<Drinks> listDrinks(@ModelAttribute Restaurant restaurant, @PathVariable long typeId) {
        if(typeId == 0) {
            return drinksService.findPublishedByRestaurant(restaurant);
        }else {
            DrinksType drinksType = drinksTypeService.findOne(typeId);
            return drinksService.findPublishedByRestaurantAndType(restaurant, drinksType);
        }
    }


}
