package com.china315net.servicesystem.Service;

import com.china315net.servicesystem.Entity.sysdept;

import java.util.List;

public interface sysdeptService {
    Integer getsysdeptcountbyCompid(Integer compid);

    List<sysdept> getsysdeptbyCompid(Integer compid, Integer limit, Integer offset);

    sysdept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysdept record);

    int insertSelective(sysdept record);
}
