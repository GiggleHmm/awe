package com.china315net.serviceactivity.ServiceImpl;
import com.china315net.serviceactivity.Entity.tjactivityprizes;
import com.china315net.serviceactivity.Service.activityprizesService;
import com.china315net.serviceactivity.mapper.tjactivityprizesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class activityprizesServiceImpl implements activityprizesService {

    @Autowired
    tjactivityprizesMapper activityPrizesMapper;

    @Override
    public List<tjactivityprizes> getactivityprizeByAcid(Integer acid) {
        return activityPrizesMapper.getactivityprizeByAcid(acid);
    }

    @Override
    public Integer getActivityPrizeCount(Integer acid) {
        return activityPrizesMapper.getActivityPrizeCount(acid);
    }

    @Override
    public tjactivityprizes selectByPrimaryKey(Integer id) {
        return activityPrizesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(tjactivityprizes record) {
        return activityPrizesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(tjactivityprizes record) {
        return activityPrizesMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return activityPrizesMapper.deleteByPrimaryKey(id);
    }
}
