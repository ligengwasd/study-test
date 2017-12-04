package com.ydb.controller;

import com.ydb.model.Greeting;
import com.ydb.model.HelloMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ligeng on 17/12/4.
 */
@RestController
@RequestMapping
@Api(description = "webSocket测试")
public class GreetingController {
    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    // server主动发给client的例子
    @RequestMapping(path="/greetings", method= RequestMethod.POST)
    public void greet(@RequestParam String greeting) {
        System.out.println(greeting);
//        String text = "[" + System.currentTimeMillis() + "]:" + greeting;
        template.convertAndSend("/topic/greetings", new Greeting(greeting));
    }
}
