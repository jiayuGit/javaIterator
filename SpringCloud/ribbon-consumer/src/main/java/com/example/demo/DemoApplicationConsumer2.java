package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class DemoApplicationConsumer2 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplicationConsumer2.class);
        springApplication.setAdditionalProfiles("consumer2");
        //启动服务器
        springApplication.run(args);
    }

}