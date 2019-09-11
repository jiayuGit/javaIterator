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
    public String index(){
        String instance = client.description();
        System.out.println("调用了");
        return "hello word"+instance;
    }
}
