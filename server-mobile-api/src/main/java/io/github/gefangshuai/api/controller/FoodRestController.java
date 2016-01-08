package io.github.gefangshuai.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.gefangshuai.api.core.AppConfigContext;
import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.service.FoodService;
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
 * Created by gefangshuai on 2015/12/23.
 */
@RestController
@RequestMapping("/api/food")
public class FoodRestController {

    @Resource
    private FoodService foodService;
    @Resource
    private AppConfigContext appConfigContext;

    @RequestMapping("{id}")
    @JsonView(CustomJsonView.RestJsonView.class)
    public Food findOne(@PathVariable long id){
        return foodService.findOne(id);
    }

    @RequestMapping("/listByIds")
    @JsonView(CustomJsonView.RestJsonView.class)
    public List<Food> listByIds(Long[] ids){
        return foodService.listByIds(ids);
    }

    @RequestMapping("/{id}/image")
    public ResponseEntity<byte[]> loadImage(@PathVariable long id) throws IOException {
        Food food = foodService.findOne(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        if (StringUtils.isBlank(food.getImagePath())) {
            return null;
        } else {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(new File(appConfigContext.getStorePath() + food.getImagePath())),
                    headers, HttpStatus.CREATED);
        }
    }
}
