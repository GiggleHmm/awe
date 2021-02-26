package com.china315net.serviceactivity.Service;

import com.china315net.serviceactivity.Entity.tjawardtype;

import java.util.List;

public interface tjawardtypeService {
    List<tjawardtype> getawtypebyCompID(Integer compid);
    List<tjawardtype> getawtypebyParentID(Integer parentid, Integer compid);
}
