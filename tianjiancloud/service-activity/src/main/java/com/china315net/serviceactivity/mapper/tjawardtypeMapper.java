package com.china315net.serviceactivity.mapper;
import com.china315net.serviceactivity.Entity.tjawardtype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;



public interface tjawardtypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tjawardtype record);

    int insertSelective(tjawardtype record);

    tjawardtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tjawardtype record);

    int updateByPrimaryKey(tjawardtype record);

    @Select("select * from tj_awardtype where compid=#{compid}")
    List<tjawardtype> getawtypebyCompID(Integer compid);

    @Select("select * from tj_awardtype where parentid=#{parentid} and compid=#{compid}")
    List<tjawardtype> getawtypebyParentID(Integer parentid, Integer compid);
}