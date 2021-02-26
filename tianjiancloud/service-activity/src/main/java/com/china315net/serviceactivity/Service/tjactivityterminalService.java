package com.china315net.serviceactivity.Service;
import com.china315net.serviceactivity.Entity.tjactivityterminal;
import java.util.List;
public interface tjactivityterminalService {
    Integer gettjactivityterminalcountbyacid(Integer acid);
    List<tjactivityterminal> gettjactivityterminalbyacid(Integer compid, Integer limit, Integer offset);
    tjactivityterminal selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(tjactivityterminal record);
    int insertSelective(tjactivityterminal record);
    int deleteByPrimaryKey(Integer id);
}