package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.server.core.config.Menu;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gefangshuai on 2015/11/13.
 */
@Menu("foods")
@Controller
@RequiresRoles("aa")
@RequestMapping("/rtat/foods")
public class FoodController {

    @RequestMapping
    public String index(){
        return "rtat/list";
    }
}
