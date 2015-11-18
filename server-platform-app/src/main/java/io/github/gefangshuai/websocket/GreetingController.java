package io.github.gefangshuai.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gefangshuai on 2015/11/17.
 */
@Controller
public class GreetingController {

    @RequestMapping("/helloIndex")
    public String index(){
        return "/hello/index";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
