package io.github.gefangshuai.api.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.gefangshuai.api.core.AppConfigContext;
import io.github.gefangshuai.rtat.model.Drinks;
import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.service.DrinksService;
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
@RequestMapping("/api/drinks")
public class DrinksRestController {

    @Resource
    private DrinksService drinksService;
    @Resource
    private AppConfigContext appConfigContext;

    @RequestMapping("{id}")
    @JsonView(CustomJsonView.RestJsonView.class)
    public Drinks findOne(@PathVariable long id){
        return drinksService.findOne(id);
    }

    @RequestMapping("/listByIds")
    @JsonView(CustomJsonView.RestJsonView.class)
    public List<Drinks> listByIds(Long[] ids){
        return drinksService.listByIds(ids);
    }

    @RequestMapping("/{id}/image")
    public ResponseEntity<byte[]> loadImage(@PathVariable long id) throws IOException {
        Drinks drinks = drinksService.findOne(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        if (StringUtils.isBlank(drinks.getImagePath())) {
            return null;
        } else {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(new File(appConfigContext.getStorePath() + drinks.getImagePath())),
                    headers, HttpStatus.CREATED);
        }
    }
}
