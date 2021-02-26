package com.china315net.serviceactivity.ServiceImpl;

import com.china315net.serviceactivity.Entity.selectlist;
import com.china315net.serviceactivity.Entity.tjactivitystrategy;
import com.china315net.serviceactivity.Service.tjactivitystrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TjactivitystrategyServiceImpl implements tjactivitystrategyService {
    @Autowired
    private com.china315net.serviceactivity.mapper.tjactivitystrategyMapper tjactivitystrategyMapper;
    @Override
    public List<tjactivitystrategy> selectActivitStrategyByCompID(Integer compid) {
        return tjactivitystrategyMapper.selectActivitStrategyByCompID(compid);
    }

    @Override
    public Integer getAllCountByCompid(Integer compid) {
        return tjactivitystrategyMapper.getAllCountByCompid(compid);
    }

    @Override
    public tjactivitystrategy selectByPrimaryKey(Integer id) {
        return tjactivitystrategyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(tjactivitystrategy record) {
        return tjactivitystrategyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<selectlist> selectActivitStrategyByCompIDForSelect(Integer compid) {
        return tjactivitystrategyMapper.selectActivitStrategyByCompIDForSelect(compid);
    }
}
