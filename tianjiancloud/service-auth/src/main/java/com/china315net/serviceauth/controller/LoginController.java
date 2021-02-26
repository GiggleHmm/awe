package com.china315net.serviceauth.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.china315net.serviceauth.dto.ResponseDTO;
import com.china315net.serviceauth.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 登录方法
     * @param account
     * @param password
     * @return
     */
    @GetMapping(value = "/login")
    public ResponseDTO<Map<String, String>> login(@RequestParam("account") String account,
                                                  @RequestParam("password") String password,
                                                  HttpServletRequest request){
        String clientType = request.getHeader("clientType");
        if(StrUtil.isEmpty(clientType)) {
            return ResponseDTO.error().setMsg("clientType不能为空");
        }
        //账号密码校验
        if(StrUtil.isNotEmpty(account) && StrUtil.isNotEmpty(password)){
            if ("admin".equals(account) && "123456a".equals(password)){
                Map<String, String> map = tokenUtil.getToken(account, clientType);
                return ResponseDTO.ok().setData(map);
            }else {
                return ResponseDTO.error().setMsg("账号或密码错误");
            }
        }else {
            return ResponseDTO.error().setMsg("账号或密码错误");
        }
    }

    /**
     * 刷新JWT
     * @param refreshToken
     * @return
     */
    @GetMapping("/refresh")
    public ResponseDTO<Map<String, String>> refreshToken(@RequestParam("refreshToken") String refreshToken,
                                                         @RequestParam("account") String account,
                                                         HttpServletRequest request){
        String clientType = request.getHeader("clientType");
        if(StrUtil.isEmpty(clientType)) {
            return ResponseDTO.error().setMsg("clientType不能为空");
        }
        Map<String, String> map = tokenUtil.refreshToken(account, clientType, refreshToken);
        if(CollUtil.isEmpty(map)) {
            return ResponseDTO.error().setMsg("refreshToken失效");
        }
        return ResponseDTO.ok().setData(map);
    }

}