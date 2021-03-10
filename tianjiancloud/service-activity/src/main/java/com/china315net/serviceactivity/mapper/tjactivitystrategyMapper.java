package com.china315net.serviceactivity.mapper;
import com.china315net.serviceactivity.Entity.selectlist;
import com.china315net.serviceactivity.Entity.tjactivitystrategy;

import org.apache.ibatis.annotations.Select;


import java.util.List;



public interface tjactivitystrategyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tjactivitystrategy record);

    int insertSelective(tjactivitystrategy record);

    tjactivitystrategy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tjactivitystrategy record);

    int updateByPrimaryKey(tjactivitystrategy record);

    @Select("select count(id) from tj_activity_strategy where compid=#{compid}")
    Integer getAllCountByCompid(Integer compid);

    @Select("select * from tj_activity_strategy where compid=#{compid} order by id desc")
    List<tjactivitystrategy> selectActivitStrategyByCompID(Integer compid);

    @Select("select id as value,strategyname as label,remarks from tj_activity_strategy where compid=#{compid} order by id desc")
    List<selectlist> selectActivitStrategyByCompIDForSelect(Integer compid);
}