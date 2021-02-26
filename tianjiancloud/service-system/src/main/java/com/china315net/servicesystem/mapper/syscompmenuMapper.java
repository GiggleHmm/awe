package com.china315net.servicesystem.mapper;

import com.china315net.servicesystem.Entity.syscompmenu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface syscompmenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(syscompmenu record);

    int insertSelective(syscompmenu record);

    syscompmenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(syscompmenu record);

    int updateByPrimaryKey(syscompmenu record);

    @Select("select count(id) from sys_comp_menu where compid=#{compid}")
    Integer getsyscompmenucountbyCompid(Integer compid);
    @Select("select * from sys_comp_menu where compid=#{compid} limit #{limit} offset #{offset}")
    List<syscompmenu> getsyscompmenubyCompid(Integer compid, Integer limit, Integer offset);

}