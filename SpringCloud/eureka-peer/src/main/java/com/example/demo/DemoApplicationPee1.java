package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoApplicationPee1 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplicationPee1.class);
        springApplication.setAdditionalProfiles("peer1");
        //启动服务器
        springApplication.run(args);
    }

}
