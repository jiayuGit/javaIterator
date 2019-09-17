package com.example.demo.service;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface HelloService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();
}
