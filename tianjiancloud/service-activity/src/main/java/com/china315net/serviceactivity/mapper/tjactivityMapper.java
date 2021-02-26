package com.china315net.serviceactivity.mapper;

import com.china315net.serviceactivity.Entity.tjactivity;
import org.apache.ibatis.annotations.Mapper;


public interface tjactivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tjactivity record);

    int insertSelective(tjactivity record);

    tjactivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tjactivity record);

    int updateByPrimaryKey(tjactivity record);
}