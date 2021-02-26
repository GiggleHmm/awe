package com.china315net.servicesystem.ServiceImpl;
import com.china315net.servicesystem.Entity.syscomp;
import com.china315net.servicesystem.Service.syscompService;
import com.china315net.servicesystem.mapper.syscompMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class syscompServiceImpl implements syscompService {
    @Autowired
    private syscompMapper syscompMapper;
    @Override
    public Integer getsyscompcountbyCompid(Integer compid) {
        return syscompMapper.getsyscompcountbyCompid(compid);
    }
    @Override
    public List<syscomp> getsyscompbyCompid(Integer compid, Integer limit, Integer offset) {
        return syscompMapper.getsyscompbyCompid(compid,limit,offset);
    }
    @Override
    public syscomp selectByPrimaryKey(Integer id) {
        return syscompMapper.selectByPrimaryKey(id);
    }
    @Override
    public int updateByPrimaryKeySelective(syscomp record) {
        return syscompMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int insertSelective(syscomp record) {
        return syscompMapper.insertSelective(record);
    }
}
