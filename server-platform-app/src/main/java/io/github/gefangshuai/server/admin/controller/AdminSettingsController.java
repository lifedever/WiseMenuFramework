package io.github.gefangshuai.server.admin.controller;

import io.github.gefangshuai.constant.ResultCode;
import io.github.gefangshuai.rtat.service.DrinksService;
import io.github.gefangshuai.rtat.service.FoodService;
import io.github.gefangshuai.rtat.service.RestaurantService;
import io.github.gefangshuai.server.core.config.Menu;
import io.github.gefangshuai.server.core.context.AppConfigContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by gefangshuai on 2015/12/21.
 */
@Menu("admin-settings")
@Controller
@RequestMapping("/admin/settings")
public class AdminSettingsController {
    @Resource
    private DrinksService drinksService;
    @Resource
    private FoodService foodService;
    @Resource
    private RestaurantService restaurantService;
    @Resource
    private AppConfigContext appConfigContext;

    @RequestMapping
    public String index() {
        return "admin/settings/index";
    }

    @RequestMapping("/thumb/rebuild/count")
    @ResponseBody
    public long thumbNeedRebuildCount() {
        long drinksCount = drinksService.count();
        long foodCount = foodService.count();
        long restaurantCount = restaurantService.count();
        return foodCount + drinksCount + restaurantCount;
    }

    @ResponseBody
    @RequestMapping("/thumb/rebuild")
    public ResultCode thumbRebuild() {
        try {
            foodService.rebuildThumb(appConfigContext.getStorePath(), appConfigContext.getGraphicsMagickHome());
            drinksService.rebuildThumb(appConfigContext.getStorePath(), appConfigContext.getGraphicsMagickHome());
            restaurantService.rebuildThumb(appConfigContext.getStorePath(), appConfigContext.getGraphicsMagickHome());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultCode.Faild;
        }
        return ResultCode.OK;
    }


}
