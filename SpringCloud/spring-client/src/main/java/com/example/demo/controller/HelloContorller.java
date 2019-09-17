package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContorller {
    @Autowired
    private DiscoveryClient client;
        @RequestMapping("/hello")
    public String index() throws InterruptedException {
        String instance = client.description();
        double time = Math.random()*3000;
        Thread.sleep((long) time);
        System.out.println("调用了 时间->"+time);
        return "hello word"+instance;
    }

}
