package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.sysusertoken;

public interface sysusertokenMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysusertoken record);

    int insertSelective(sysusertoken record);

    sysusertoken selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysusertoken record);

    int updateByPrimaryKey(sysusertoken record);
}