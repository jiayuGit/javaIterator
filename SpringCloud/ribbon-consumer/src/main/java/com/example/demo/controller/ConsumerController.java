package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@RestController
public class ConsumerController {
    @Autowired
    private HelloService helloService;
    @RequestMapping(value = "ribbon-consumer",method= RequestMethod.GET)
    public String helloConsumer(){
        long startTime = System.currentTimeMillis();
        String res = helloService.helloService();
        long end = System.currentTimeMillis();
        System.out.println("请求时间->"+(end-startTime));
        return res+"请求时间->"+(end-startTime);
    }
    @RequestMapping(value = "user",method = RequestMethod.GET)
    public SecurityProperties.User selectUserById(String id) throws ExecutionException, InterruptedException {
        return helloService.getUserById(id).get();//.get();
    }
    @RequestMapping(value = "updata",method = RequestMethod.GET)
    public String updata(long id){
        SecurityProperties.User user = new SecurityProperties.User();
        user.setPassword(String.valueOf(id));
        helloService.updata(user);
        return "OK";

    }
}
