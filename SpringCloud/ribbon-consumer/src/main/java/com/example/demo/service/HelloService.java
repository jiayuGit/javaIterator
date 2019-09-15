package com.example.demo.service;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        String res = restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
        return res;
    }

    @HystrixCommand
    public Future<SecurityProperties.User>
     getUserById( String id ){

        return new AsyncResult<SecurityProperties.User>() {
            @Override
            public SecurityProperties.User invoke() {
                return restTemplate.getForObject("http://USER-SERVICE/user?id={1}",SecurityProperties.User.class,id);
            }
        };
    }
    @CacheResult
    @HystrixCommand(commandKey = "myCacheKey")
    public void getCache(String id) {
        System.out.println("执行查询方法");
    }
    @CacheRemove(commandKey = "myCacheKey")
    @HystrixCommand
    public void removeCache(String id) {
        System.out.println("删除缓存方法");
    }
    public String getUserId(String id) {
        System.out.println("执行缓存");
        return id;
    }
    public Long getUserByIdCacheKeyDelete(SecurityProperties.User user){
        return Long.valueOf(user.getPassword());
    }
    public Long getUserByIdCacheKey(Long id){
        return id;
    }

    //@CacheRemove(commandKey = "getUserByIdCacheKey")
    @HystrixCommand
    public void updata(SecurityProperties.User user){
        restTemplate.postForObject("http:/USER-SERVICE/updataUser",user,SecurityProperties.User.class);
    }

    public String helloFallback(){
        return "error";
    }

}
