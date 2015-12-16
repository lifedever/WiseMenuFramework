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
        StringBuilder sb = new StringBuilder();
        sb.append("<center>");
        sb.append("<h1>Welcome!</h1>");
        sb.append("<p>server is running!</p>");
        sb.append("</center>");
        return sb.toString();
    }
}
