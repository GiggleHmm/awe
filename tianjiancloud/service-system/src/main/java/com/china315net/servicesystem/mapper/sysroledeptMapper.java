package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.sysroledept;

public interface sysroledeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysroledept record);

    int insertSelective(sysroledept record);

    sysroledept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysroledept record);

    int updateByPrimaryKey(sysroledept record);
}