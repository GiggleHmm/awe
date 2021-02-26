package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.sysrolemenu;

public interface sysrolemenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysrolemenu record);

    int insertSelective(sysrolemenu record);

    sysrolemenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysrolemenu record);

    int updateByPrimaryKey(sysrolemenu record);
}