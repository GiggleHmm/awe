package com.china315net.serviceactivity.Service;
import com.china315net.serviceactivity.Entity.tjactivityproduct;
import java.util.List;

public interface tjactivityproductService {
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(tjactivityproduct record);
    tjactivityproduct selectByPrimaryKey(Integer id);
    int insertSelective(tjactivityproduct record);
    Integer getacitivityproductcountbyAcid(Integer acid);
    List<tjactivityproduct> getactivityproductbyAcid(Integer acid, Integer limit, Integer offset);
}
