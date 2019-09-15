package com.example.demo.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @RequestMapping("/user")
    public SecurityProperties.User selectUserById(long id){
        SecurityProperties.User user = new SecurityProperties.User();
        user.setPassword(String.valueOf(id));
        System.out.println(id);
        return user;
    }
    @RequestMapping("/updataUser")
    public String updataUser(SecurityProperties.User user){

        return "OK";
    }
}
