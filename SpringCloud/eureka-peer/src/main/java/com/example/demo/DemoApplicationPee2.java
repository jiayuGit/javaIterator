package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoApplicationPee2 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplicationPee2.class);
        springApplication.setAdditionalProfiles("peer2");
        //启动服务器
        springApplication.run(args);
    }

}