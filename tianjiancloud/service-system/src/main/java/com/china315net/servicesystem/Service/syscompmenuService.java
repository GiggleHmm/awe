package com.china315net.servicesystem.Service;

import com.china315net.servicesystem.Entity.syscompmenu;
import java.util.List;
public interface syscompmenuService {
    Integer getsyscompmenucountbyCompid(Integer compid);
    List<syscompmenu> getsyscompmenubyCompid(Integer compid, Integer limit, Integer offset);
    syscompmenu selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(syscompmenu record);
    int insertSelective(syscompmenu record);
}
