package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class DemoApplicationDashboard {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationDashboard.class, args);
    }

}
