package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.syscomp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface syscompMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(syscomp record);

    int insertSelective(syscomp record);

    syscomp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(syscomp record);

    int updateByPrimaryKey(syscomp record);

    @Select("select count(id) from sys_comp where compid=#{compid}")
    Integer getsyscompcountbyCompid(Integer compid);
    @Select("select * from sys_comp where compid=#{compid} limit #{limit} offset #{offset}")
    List<syscomp> getsyscompbyCompid(Integer compid, Integer limit, Integer offset);

}