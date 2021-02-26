package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.sysuser;

public interface sysuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(sysuser record);

    int insertSelective(sysuser record);

    sysuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(sysuser record);

    int updateByPrimaryKey(sysuser record);
}