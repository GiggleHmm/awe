package com.china315net.servicesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.china315net.servicesystem.mapper")
public class ServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSystemApplication.class, args);
    }

}
