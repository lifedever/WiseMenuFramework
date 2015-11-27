package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.service.FoodService;
import io.github.gefangshuai.server.core.config.Menu;
import io.github.gefangshuai.server.core.context.AppConfigContext;
import io.github.gefangshuai.utils.StoreUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * Created by gefangshuai on 2015/11/16.
 */
@Controller
@Menu("foods-list")
@RequestMapping("/rtat/foods")
public class FoodFormController {
    @Resource
    private FoodService foodService;

    @Resource
    private AppConfigContext appConfigContext;

    @ModelAttribute("food")
    public Food getFoodModel(@PathVariable Long id) {
        Food food;
        if (id == null || id == 0) {
            food = new Food();
            food.setId(0l);
        } else {
            food = foodService.findOne(id);
        }
        return food;
    }

    @RequestMapping("/add/{id}")
    public String addFood() {
        return "rtat/foods/form";
    }

    @RequestMapping("/edit/{id}")
    public String editFood(@ModelAttribute Food food, Model model){
        model.addAttribute("food", food);
        return "rtat/foods/form";
    }

    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
    public String saveFood(@ModelAttribute Food food, double xText, double yText, double widthText, double heightText, MultipartFile file) {
        if (file != null && file.getSize()>0) {
            try {
                String relativePath = StoreUtils.storeCutFile(appConfigContext.getStorePath(), StoreUtils.getExtension(file.getOriginalFilename()), file.getInputStream(), (int) xText, (int) yText, (int) widthText, (int) heightText);
                food.setImagePath(relativePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        foodService.save(food);
        return "redirect:/rtat/foods";
    }

    @RequestMapping("/img/{id}")
    public ResponseEntity<byte[]> loadImage(@ModelAttribute Food food) throws IOException {
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
