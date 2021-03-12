package com.china315net.servicezuul.filter;



import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

import java.net.URI;


@Component
public class RGlobalFilter implements GlobalFilter, Ordered {

    private static  String GATEWAY_REQUEST_URL_ATTR = "";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest str = exchange.getRequest();
        if (str.getQueryParams().containsKey("demo")){
            addOriginalRequestUrl(exchange, str.getURI());
            String newPath =str.getPath()+"demo";
            ServerHttpRequest newRequest = str.mutate()
                    .path(newPath)
                    .build();
            exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
            return chain.filter(exchange.mutate()
                    .request(newRequest).build());
        }
        return chain.filter(exchange);
    }



    private void addOriginalRequestUrl(ServerWebExchange exchange, URI uri) {
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
