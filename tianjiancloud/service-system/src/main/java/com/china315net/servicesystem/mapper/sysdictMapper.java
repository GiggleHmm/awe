package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.sysdict;

public interface sysdictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysdict record);

    int insertSelective(sysdict record);

    sysdict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysdict record);

    int updateByPrimaryKey(sysdict record);
}