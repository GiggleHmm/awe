package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.sysuserrole;

public interface sysuserroleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysuserrole record);

    int insertSelective(sysuserrole record);

    sysuserrole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysuserrole record);

    int updateByPrimaryKey(sysuserrole record);
}