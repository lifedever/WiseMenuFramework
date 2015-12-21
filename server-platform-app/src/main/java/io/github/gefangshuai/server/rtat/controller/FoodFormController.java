package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.model.FoodType;
import io.github.gefangshuai.rtat.service.FoodService;
import io.github.gefangshuai.rtat.service.FoodTypeService;
import io.github.gefangshuai.server.core.config.Menu;
import io.github.gefangshuai.server.core.context.AppConfigContext;
import io.github.gefangshuai.server.core.utils.FlashMessageUtils;
import io.github.gefangshuai.server.core.utils.WebUtils;
import io.github.gefangshuai.server.utils.ModelBeanUtils;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
    private FoodTypeService foodTypeService;

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

    @RequestMapping("/edit/{id}")
    public String editFood(@ModelAttribute Food food, Long typeId, Model model, RedirectAttributes redirectAttributes) {
        if (food == null) {
            FlashMessageUtils.error(redirectAttributes, "相关菜品不存在！");
            return "redirect:/rtat/foods";
        }
        if (food.getId() == 0 && typeId != null) {
            food.setFoodType(foodTypeService.findOne(typeId));
        }

        List<FoodType> foodTypes = foodTypeService.findByRestaurant(ModelBeanUtils.getCurrentRestaurant());
        model.addAttribute("foodTypes", foodTypes);
        model.addAttribute("food", food);
        return "rtat/foods/form";
    }

    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
    public String saveFood(@ModelAttribute Food food, Long typeId, double xText, double yText, double widthText, double heightText, MultipartFile file) {
        if (file != null && file.getSize() > 0) {
            try {
                String relativePath = StoreUtils.storeCutFileWithThumbAndCompress(
                        appConfigContext.getGraphicsMagickHome(),
                        appConfigContext.getStorePath(),
                        StoreUtils.getExtension(file.getOriginalFilename()),
                        file.getInputStream(),
                        (int) xText,
                        (int) yText,
                        (int) widthText,
                        (int) heightText,
                        400, 300
                );
                food.setImagePath(relativePath);
                food.setThumbPath(StoreUtils.getThumbPath(relativePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (typeId != null) {
            food.setFoodType(foodTypeService.findOne(typeId));
        }
        foodService.save(food);
        return "redirect:/rtat/foods";
    }

    @RequestMapping("/published/{id}/{published}")
    public String published(@ModelAttribute Food food, @PathVariable boolean published) {
        food.setPublished(published);
        foodService.save(food);
        return "redirect:/rtat/foods";
    }


    @RequestMapping("/img/{id}")
    public ResponseEntity<byte[]> loadImage(@ModelAttribute Food food) throws IOException {
        if (StringUtils.isBlank(food.getImagePath())) {
            return null;
        } else {
            return WebUtils.loadImage(appConfigContext.getStorePath() + food.getImagePath());

        }
    }


    @RequestMapping("/img/{id}/thumb")
    public ResponseEntity<byte[]> loadImageThumb(@ModelAttribute Food food) throws IOException {

        if (StringUtils.isBlank(food.getImagePath())) {
            return null;
        } else {
            return WebUtils.loadImage(appConfigContext.getStorePath() + food.getThumbPath());
        }
    }


}
