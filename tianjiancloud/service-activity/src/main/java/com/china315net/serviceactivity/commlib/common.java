package com.china315net.serviceactivity.commlib;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class common {
    public static String FirstLetterUpperName(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);

    }

    public JSONObject ReturnQureyObj(Integer current, Integer pagesize, Boolean secess, Integer count, Object list){
        JSONObject obj = new JSONObject();
        obj.put("current", current);
        obj.put("pageSize", pagesize);
        obj.put("success", secess);
        obj.put("total",count);
        obj.put("data", list);
        return obj;
    }
}
