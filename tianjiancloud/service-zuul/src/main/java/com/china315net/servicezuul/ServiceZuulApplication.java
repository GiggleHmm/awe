package com.china315net.servicezuul;

//import com.china315net.servicezuul.filter.ManagerFilter;
//import com.fasterxml.jackson.core.filter.TokenFilter;
//import com.china315net.servicezuul.filter.RequestGlobalFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

//    @Bean
//    RequestGlobalFilter requestGlobalFilter(){
//        return new RequestGlobalFilter();
//    }

//    @Bean
//    TokenFilter tokenFilter() {
//        return new TokenFilter();
//    }


//    @Bean
//    ManagerFilter tokenFilter() {
//        return new ManagerFilter();
//    }
}
