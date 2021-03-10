package com.china315net.serviceactivity.mapper;
import com.china315net.serviceactivity.Entity.tjactivityagent;

import org.apache.ibatis.annotations.Select;


import java.util.List;


public interface tjactivityagentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tjactivityagent record);

    int insertSelective(tjactivityagent record);

    tjactivityagent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tjactivityagent record);

    int updateByPrimaryKey(tjactivityagent record);

    @Select("select count(id) from tj_activity_agent where acid=#{acid}")
    Integer gettjactivityagentcountbyacid(Integer acid);
    @Select("select * from tj_activity_agent where acid=#{acid} limit #{limit} offset #{offset}")
    List<tjactivityagent> gettjactivityagentbyacid(Integer acid, Integer limit, Integer offset);
}