package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.sysdept;

public interface sysdeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysdept record);

    int insertSelective(sysdept record);

    sysdept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysdept record);

    int updateByPrimaryKey(sysdept record);
}