package io.github.gefangshuai.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gefangshuai on 2015/11/17.
 */
@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/helloSocket")
    public String index(){
        return "/hello/index";
    }

    @MessageMapping("/change-notice")
    @SendTo("/topic/notice")
    public String greeting(String value) throws InterruptedException {
        return value;
    }
}
