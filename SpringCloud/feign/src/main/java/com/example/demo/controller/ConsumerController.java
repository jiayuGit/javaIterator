package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    DemoApplication.HelloService helloService;

    @RequestMapping(value = "feign-consumer",method=RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }
}
