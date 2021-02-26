package com.china315net.servicesystem.ServiceImpl;
import com.china315net.servicesystem.Entity.sysdept;
import com.china315net.servicesystem.Service.sysdeptService;
import com.china315net.servicesystem.mapper.sysdeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class sysdeptServiceImpl implements sysdeptService {
    @Autowired
    private sysdeptMapper sysdeptMapper;
    @Override
    public Integer getsysdeptcountbyCompid(Integer compid) {
        return null;
     //   return sysdeptMapper(compid);
    }
    @Override
    public List<sysdept> getsysdeptbyCompid(Integer compid, Integer limit, Integer offset) {
        return null;
        //return sysdeptMapper.getsysdeptbyCompid(compid,limit,offset);
    }
    @Override
    public sysdept selectByPrimaryKey(Long id) {
        return sysdeptMapper.selectByPrimaryKey(id);
    }
    @Override
    public int updateByPrimaryKeySelective(sysdept record) {
        return sysdeptMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int insertSelective(sysdept record) {
        return sysdeptMapper.insertSelective(record);
    }
}
