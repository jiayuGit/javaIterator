package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@EnableFeignClients(basePackages = {"com.example.demo.service"})
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.example.demo.controller"})
public class DemoApplicationFeign {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationFeign.class, args);
    }
    @FeignClient(name = "hello-service")
    public interface HelloService {
        @RequestMapping(value = "/hello",method = RequestMethod.GET)
        String hello();
    }
}
