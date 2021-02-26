package com.china315net.serviceactivity.Service;
import com.china315net.serviceactivity.Entity.tjactivityprizes;

import java.util.List;

public interface activityprizesService {
    List<tjactivityprizes> getactivityprizeByAcid(Integer acid);
    Integer getActivityPrizeCount(Integer acid);
    tjactivityprizes selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(tjactivityprizes record);
    int insertSelective(tjactivityprizes record);
    int deleteByPrimaryKey(Integer id);
}
