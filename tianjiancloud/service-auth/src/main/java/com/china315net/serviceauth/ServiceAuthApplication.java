package com.china315net.serviceauth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ServiceAuthApplication {


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}
