package com.china315net.servicezuul.filter;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.china315net.servicezuul.constant.StatusCodeConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;


@Component
@Configuration
public class RequestGlobalFilter implements GlobalFilter, Ordered {
    /**
     * 不拦截的urL集合
     */
    @Value("#{'${ignore.urls}'.split(',')}")
    public List<String> ignoreUrl;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String requestUrl = exchange.getRequest().getPath().toString();

        boolean status = CollectionUtil.contains(ignoreUrl, requestUrl);

        /**
         * 增加
         */

//        try{
//            String key=stringRedisTemplate.opsForValue().get("clientKey");
//            String tokenValues=(String)stringRedisTemplate.opsForHash().get(key,"token");
//        }catch (Exception e){
//            ServerHttpResponse response = exchange.getResponse();
//            JSONObject message = new JSONObject();
//            message.put("code", StatusCodeConstants.TOKEN_NONE);
//            message.put("message", "认证失败");
//            message.put("ctime", System.currentTimeMillis());
//            byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
//            DataBuffer buffer = response.bufferFactory().wrap(bits);
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            response.getHeaders().add("Content-Type", "text/json;charset=UTF-8");
//            return response.writeWith(Mono.just(buffer));
//        }


        /**
         * 分割线
         */

        if (!status) {

            String tokenV=null;
            String key=null;


            key=stringRedisTemplate.opsForValue().get("clientKey");
            tokenV=(String)stringRedisTemplate.opsForHash().get(key,"token");


            String token =tokenV;
         //   String token = exchange.getRequest().getHeaders().getFirst("Authorization");

         //   clientType用于区分不同的端，在做校验token时需要
            String clientType = exchange.getRequest().getHeaders().getFirst("clientType");
            ServerHttpResponse response = exchange.getResponse();
            if (StrUtil.isBlank(token) || StrUtil.isBlank(clientType)) {

                JSONObject message = new JSONObject();
                message.put("code", StatusCodeConstants.TOKEN_NONE);
                message.put("message", "认证失败");
                message.put("ctime", System.currentTimeMillis());
                byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
                DataBuffer buffer = response.bufferFactory().wrap(bits);
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                response.getHeaders().add("Content-Type", "text/json;charset=UTF-8");
                return response.writeWith(Mono.just(buffer));

            } else {

                //校验token
                String userPhone = verifyJWT(token, clientType);

                if (StrUtil.isEmpty(userPhone)) {
                    JSONObject message = new JSONObject();
                    message.put("code", StatusCodeConstants.TOKEN_ERROR);
                    message.put("message", "认证失败，请重新登录");
                    message.put("ctime", System.currentTimeMillis());
                    byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
                    DataBuffer buffer = response.bufferFactory().wrap(bits);
                    response.setStatusCode(HttpStatus.UNAUTHORIZED);
                    response.getHeaders().add("Content-Type", "text/json;charset=UTF-8");
                    return response.writeWith(Mono.just(buffer));
                }

                //将现在的request，添加当前身份
                ServerHttpRequest mutableReq = exchange.getRequest().mutate().header("Authorization-UserName", userPhone).build();
                ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
                return chain.filter(mutableExchange);
            }
        }

        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {

        return 0;

    }

    /**
     * JWT验证
     *
     * @param token
     * @return userPhone
     */
    private String verifyJWT(String token, String clientType) {

        String userPhone;

        try {

            Algorithm algorithm = Algorithm.HMAC256(clientType);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("userPhone")
                    .build();

            DecodedJWT jwt = verifier.verify(token);
            userPhone = jwt.getClaim("phone").asString();
            // 判断用户是否退出登录
            String key = SecureUtil.md5(clientType + userPhone);
            if(!stringRedisTemplate.hasKey(key)) {
                return "";
            }

        } catch (JWTVerificationException e) {
            return "";
        }

        return userPhone;

    }
}
