package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {
    @Value("${from}")
    private String form;
    @Autowired
    private Environment env;
    @RequestMapping("/from")
    public String getFrom(){
        System.out.println(form);
        System.out.println(env.getProperty("from","undefined"));
        return env.getProperty("from","undefined");
    }

}
