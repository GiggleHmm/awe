package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.sysmenu;

public interface sysmenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysmenu record);

    int insertSelective(sysmenu record);

    sysmenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysmenu record);

    int updateByPrimaryKey(sysmenu record);
}