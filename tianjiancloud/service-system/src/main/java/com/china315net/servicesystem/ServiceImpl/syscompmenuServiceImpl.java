package com.china315net.servicesystem.ServiceImpl;
import com.china315net.servicesystem.Entity.syscompmenu;
import com.china315net.servicesystem.Service.syscompmenuService;
import com.china315net.servicesystem.mapper.syscompmenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class syscompmenuServiceImpl implements syscompmenuService {
    @Autowired
    private syscompmenuMapper syscompmenuMapper;
    @Override
    public Integer getsyscompmenucountbyCompid(Integer compid) {
        return syscompmenuMapper.getsyscompmenucountbyCompid(compid);
    }
    @Override
    public List<syscompmenu> getsyscompmenubyCompid(Integer compid, Integer limit, Integer offset) {
        return syscompmenuMapper.getsyscompmenubyCompid(compid,limit,offset);
    }
    @Override
    public syscompmenu selectByPrimaryKey(Integer id) {
        return syscompmenuMapper.selectByPrimaryKey(id);
    }
    @Override
    public int updateByPrimaryKeySelective(syscompmenu record) {
        return syscompmenuMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int insertSelective(syscompmenu record) {
        return syscompmenuMapper.insertSelective(record);
    }
}
