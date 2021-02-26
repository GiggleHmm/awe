package com.china315net.serviceactivity.ServiceImpl;
import com.china315net.serviceactivity.Entity.tjactivityproduct;
import com.china315net.serviceactivity.Service.tjactivityproductService;
import com.china315net.serviceactivity.mapper.tjactivityproductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class tjactivityproductServiceImpl implements tjactivityproductService {
    @Autowired
    private tjactivityproductMapper tjactivityproductMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tjactivityproductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(tjactivityproduct record) {
        return tjactivityproductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public tjactivityproduct selectByPrimaryKey(Integer id) {
        return tjactivityproductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(tjactivityproduct record) {
        return tjactivityproductMapper.insertSelective(record);
    }

    @Override
    public Integer getacitivityproductcountbyAcid(Integer acid) {
        return tjactivityproductMapper.getacitivityproductcountbyAcid(acid);
    }

    @Override
    public List<tjactivityproduct> getactivityproductbyAcid(Integer acid, Integer limit, Integer offset) {
        return tjactivityproductMapper.getactivityproductbyAcid(acid,limit,offset);
    }
}
