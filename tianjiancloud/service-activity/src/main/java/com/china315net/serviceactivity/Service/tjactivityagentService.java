package com.china315net.serviceactivity.Service;
import com.china315net.serviceactivity.Entity.tjactivityagent;
import java.util.List;
public interface tjactivityagentService {
    Integer gettjactivityagentcountbyacid(Integer acid);
    List<tjactivityagent> gettjactivityagentbyacid(Integer acid, Integer limit, Integer offset);
    tjactivityagent selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(tjactivityagent record);
    int insertSelective(tjactivityagent record);
    int deleteByPrimaryKey(Integer id);
    List<tjactivityagent> selectAllSmart(Integer compid, String filter, String sorter, Integer lmt, Integer offst);
    Integer getCountByFilter(Integer compid,String filter);
}
