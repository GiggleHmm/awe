package com.china315net.serviceactivity.mapper;

import com.china315net.serviceactivity.Entity.tjactivityprizes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;



public interface tjactivityprizesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tjactivityprizes record);

    int insertSelective(tjactivityprizes record);

    tjactivityprizes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tjactivityprizes record);

    int updateByPrimaryKey(tjactivityprizes record);

    @Select("SELECT * from tj_activity_prizes where acid=#{acid}")
    List<tjactivityprizes> getactivityprizeByAcid(Integer acid);

    @Select("SELECT count(id) from tj_activity_prizes where acid=#{acid}")
    Integer getActivityPrizeCount(Integer acid);
}