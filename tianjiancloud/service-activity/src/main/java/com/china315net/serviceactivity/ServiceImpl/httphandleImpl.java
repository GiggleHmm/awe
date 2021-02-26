package com.china315net.serviceactivity.ServiceImpl;

import com.china315net.serviceactivity.Service.httphandle;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class httphandleImpl implements httphandle {
    RestTemplate restTemplate = new RestTemplate();
    @Override
    public String GetData(String getString) {

        return restTemplate.getForObject(getString,String.class);
    }
}
