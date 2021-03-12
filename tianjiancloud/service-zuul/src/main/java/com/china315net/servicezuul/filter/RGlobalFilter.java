package com.china315net.servicezuul.filter;



import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.addOriginalRequestUrl;



/**
 * @author asus
 */
@Component
@Configuration
public class RGlobalFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest str = exchange.getRequest();
        String url="/rest/service-activity/tjactivity/list";

        System.out.println("-------------");
        System.out.println(str.getURI().getPath());
        System.out.println("-------------");

        if (url.equals(str.getURI().getPath())){
            addOriginalRequestUrl(exchange, str.getURI());


            String newPath =str.getPath()+"/1";

            ServerHttpRequest newRequest = str.mutate()
                    .path(newPath)
                    .build();

            System.out.println("++++++++++++++");
            System.out.println(newPath);
            System.out.println("++++++++++++++");

            exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());

            return chain.filter(exchange.mutate()
                    .request(newRequest).build());
        }

        return chain.filter(exchange);
    }



    @Override
    public int getOrder() {
        return 0;
    }

}
