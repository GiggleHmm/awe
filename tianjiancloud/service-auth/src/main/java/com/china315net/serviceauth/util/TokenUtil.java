package com.china315net.serviceauth.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Component
public class TokenUtil {

    @Value("${token.expire.time}")
    private long tokenExpireTime;

    @Value("${refresh.token.expire.time}")
    private long refreshTokenExpireTime;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 生成token和refreshToken
     * @param account
     * @param type
     * @return
     */
    public Map<String, String> getToken(String account, String type){
        //生成refreshToken
        String refreshToken = UUID.randomUUID().toString().replaceAll("-","");
        String token = this.buildJWT(account, type);
        String key = SecureUtil.md5(type + account);
        //向hash中放入数值
        stringRedisTemplate.opsForHash().put(key,"token", token);
        stringRedisTemplate.opsForHash().put(key,"refreshToken", refreshToken);
        //设置key过期时间
        stringRedisTemplate.expire(key, refreshTokenExpireTime, TimeUnit.MILLISECONDS);
        Map<String , String> map = new HashMap<>(2);
        map.put("token", token);
        map.put("refreshToken", refreshToken);
        return map;
    }

    /**
     * 刷新token
     * @param account
     * @param type
     * @param refreshToken
     * @return
     */
    public Map<String, String> refreshToken(String account, String type, String refreshToken){
        String key = SecureUtil.md5(type + account);
        String oldRefresh = (String) stringRedisTemplate.opsForHash().get(key, "refreshToken");
        if (StrUtil.isBlank(oldRefresh)){
            return null;
        }else {
            if (!oldRefresh.equals(refreshToken)){
                return null;
            }else {
                String token = this.buildJWT(account, type);
                stringRedisTemplate.opsForHash().put(key,"token", token);
                stringRedisTemplate.opsForHash().put(key,"refreshToken", refreshToken);
                stringRedisTemplate.expire(key, refreshTokenExpireTime, TimeUnit.MILLISECONDS);
                Map<String , String> map = new HashMap<>(2);
                map.put("token", token);
                map.put("refreshToken", refreshToken);
                return map;
            }
        }
    }

    /**
     * 删除key
     * @param account
     * @param type
     */
    public boolean removeToken(String account, String type){
        String key = SecureUtil.md5(type + account);
        return stringRedisTemplate.delete(key);
    }

    /**
     * 生成jwt
     * @param account 账号
     * @param prefix 前缀
     * @return
     */
    private String buildJWT(String account, String prefix){
        //生成jwt
        Date now = new Date();
        Algorithm algo = Algorithm.HMAC256(prefix);
        String token = JWT.create()
                //签发人
                .withIssuer("userPhone")
                //签发时间
                .withIssuedAt(now)
                //过期时间
                .withExpiresAt(new Date(now.getTime() + tokenExpireTime))
                //自定义的存放的数据
                .withClaim("phone", account)
                //签名
                .sign(algo);
        return token;
    }
}
