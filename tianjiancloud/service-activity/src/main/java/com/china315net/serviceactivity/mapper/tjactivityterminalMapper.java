package com.china315net.serviceactivity.mapper;
import com.china315net.serviceactivity.Entity.tjactivityterminal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;



public interface tjactivityterminalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tjactivityterminal record);

    int insertSelective(tjactivityterminal record);

    tjactivityterminal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tjactivityterminal record);

    int updateByPrimaryKey(tjactivityterminal record);

    @Select("select count(id) from tj_activity_terminal where acid=#{acid}")
    Integer gettjactivityterminalcountbyacid(Integer acid);
    @Select("select * from tj_activity_terminal where acid=#{acid} limit #{limit} offset #{offset}")
    List<tjactivityterminal> gettjactivityterminalbyacid(Integer acid, Integer limit, Integer offset);
}