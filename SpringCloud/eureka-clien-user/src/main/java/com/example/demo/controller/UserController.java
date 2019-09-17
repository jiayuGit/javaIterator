package com.example.demo.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "/updata-user",method = RequestMethod.POST)
    public String updataUser(@RequestBody SecurityProperties.User user){
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        return "OK"+user.getPassword()+user.getName();
    }
}
