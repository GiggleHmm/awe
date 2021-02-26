package com.china315net.servicesystem.Service;
import com.china315net.servicesystem.Entity.syscomp;
import java.util.List;
public interface syscompService {
    Integer getsyscompcountbyCompid(Integer compid);
    List<syscomp> getsyscompbyCompid(Integer compid, Integer limit, Integer offset);
    syscomp selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(syscomp record);
    int insertSelective(syscomp record);
}
