package com.china315net.serviceauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableEurekaClient
public class ServiceAuthApplication {


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}
