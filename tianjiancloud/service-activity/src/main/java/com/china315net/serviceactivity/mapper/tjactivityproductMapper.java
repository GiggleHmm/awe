package com.china315net.serviceactivity.mapper;
import com.china315net.serviceactivity.Entity.tjactivityproduct;

import org.apache.ibatis.annotations.Select;


import java.util.List;


public interface tjactivityproductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tjactivityproduct record);

    int insertSelective(tjactivityproduct record);

    tjactivityproduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tjactivityproduct record);

    int updateByPrimaryKey(tjactivityproduct record);

    @Select("select count(id) from tj_activity_product where acid=#{acid}")
    Integer getacitivityproductcountbyAcid(Integer acid);

    @Select("select * from tj_activity_product where acid=#{acid} limit #{limit} offset #{offset}")
    List<tjactivityproduct> getactivityproductbyAcid(Integer acid, Integer limit, Integer offset);


}