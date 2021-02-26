package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.syslog;

public interface syslogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(syslog record);

    int insertSelective(syslog record);

    syslog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(syslog record);

    int updateByPrimaryKey(syslog record);
}