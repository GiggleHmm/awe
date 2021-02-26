package com.china315net.serviceactivity.Service;
import com.china315net.serviceactivity.Entity.activityall;
import com.china315net.serviceactivity.Entity.tjactivity;

import java.sql.Timestamp;
import java.util.List;

public interface tjactivityService {
    tjactivity selectByPrimaryKey(Integer id);
    Integer insertSelective(tjactivity record);
    Integer updateByPrimaryKeySelective(tjactivity record);
    Integer deleteByPrimaryKey(Integer id);
    List<activityall> selectAllSmart(Integer compid, String filter, String sorter, Integer lmt, Integer offst);
    Integer getCountByFilter(Integer compid,String filter);
}
