package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.sysrole;

public interface sysroleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysrole record);

    int insertSelective(sysrole record);

    sysrole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysrole record);

    int updateByPrimaryKey(sysrole record);
}