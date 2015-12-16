package io.github.gefangshuai.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gefangshuai on 2015/12/16.
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "server is running!";
    }
}
