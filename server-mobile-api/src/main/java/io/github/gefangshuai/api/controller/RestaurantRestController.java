package io.github.gefangshuai.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.gefangshuai.api.core.AppConfigContext;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.RestaurantService;
import io.github.gefangshuai.utils.CustomJsonView;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by gefangshuai on 2015/12/15.
 */
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantRestController {

    @Resource
    private RestaurantService restaurantService;
    @Resource
    private AppConfigContext appConfigContext;

    @RequestMapping
    @JsonView(CustomJsonView.RestJsonView.class)
    public List<Restaurant> listRestaurants(String callback) {
        return restaurantService.findValidAndOpening();
    }

    @RequestMapping("{id}")
    @JsonView(CustomJsonView.RestJsonView.class)
    public Restaurant loadRestaurant(@PathVariable long id) {
        return restaurantService.findOne(id);
    }

    @RequestMapping("{id}/image")
    public ResponseEntity<byte[]> loadShopImage(@PathVariable long id) throws IOException {
        Restaurant restaurant = restaurantService.findOne(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        if (StringUtils.isBlank(restaurant.getImagePath())) {
            return null;
        } else {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(new File(appConfigContext.getStorePath() + restaurant.getImagePath())),
                    headers, HttpStatus.CREATED);
        }
    }
}