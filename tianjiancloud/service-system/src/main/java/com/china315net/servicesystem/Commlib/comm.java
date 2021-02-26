package com.china315net.servicesystem.Commlib;
import com.alibaba.fastjson.JSONObject;

public class comm {
    public static JSONObject getJsonObject(int i) {
        Integer rstcout = i;
        if (rstcout > 0) {
            return (JSONObject) JSONObject.parse("{\"msg\":\"ok\",\"rst\":" + rstcout + "}");
        } else {
            return (JSONObject) JSONObject.parse("{\"msg\":\"fail\",\"rst\":" + rstcout + "}");
        }
    }
}
