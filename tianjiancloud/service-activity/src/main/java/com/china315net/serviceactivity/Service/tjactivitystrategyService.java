package com.china315net.serviceactivity.Service;
import com.china315net.serviceactivity.Entity.selectlist;
import com.china315net.serviceactivity.Entity.tjactivitystrategy;

import java.util.List;

public interface tjactivitystrategyService {
    List<tjactivitystrategy> selectActivitStrategyByCompID(Integer compid);
    Integer getAllCountByCompid(Integer compid);
    tjactivitystrategy selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(tjactivitystrategy record);
    List<selectlist> selectActivitStrategyByCompIDForSelect(Integer compid);
}
