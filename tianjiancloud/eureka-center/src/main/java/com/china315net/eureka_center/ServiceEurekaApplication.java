package com.china315net.eureka_center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author asus
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEurekaApplication.class, args);
    }
}
