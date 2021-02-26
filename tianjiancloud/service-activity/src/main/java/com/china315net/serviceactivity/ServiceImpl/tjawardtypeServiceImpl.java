package com.china315net.serviceactivity.ServiceImpl;

import com.china315net.serviceactivity.Entity.tjawardtype;
import com.china315net.serviceactivity.Service.tjawardtypeService;
import com.china315net.serviceactivity.mapper.tjawardtypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tjawardtypeServiceImpl implements tjawardtypeService {
    @Autowired
    private tjawardtypeMapper tjawardtypeMapper;

    @Override
    public List<tjawardtype> getawtypebyCompID(Integer compid) {
        return tjawardtypeMapper.getawtypebyCompID(compid);
    }

    @Override
    public List<tjawardtype> getawtypebyParentID(Integer parentid,Integer compid) {
        return tjawardtypeMapper.getawtypebyParentID(parentid,compid);
    }
}
