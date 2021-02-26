package com.china315net.serviceactivity.ServiceImpl;
import com.china315net.serviceactivity.Entity.tjactivityterminal;
import com.china315net.serviceactivity.Service.tjactivityterminalService;
import com.china315net.serviceactivity.mapper.tjactivityterminalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class tjactivityterminalServiceImpl implements tjactivityterminalService {
    @Autowired
    private tjactivityterminalMapper tjactivityterminalMapper;

    @Override
    public Integer gettjactivityterminalcountbyacid(Integer acid) {
        return tjactivityterminalMapper.gettjactivityterminalcountbyacid(acid);
    }

    @Override
    public List<tjactivityterminal> gettjactivityterminalbyacid(Integer acid, Integer limit, Integer offset) {
        return tjactivityterminalMapper.gettjactivityterminalbyacid(acid,limit,offset);
    }

    @Override
    public tjactivityterminal selectByPrimaryKey(Integer id) {
        return tjactivityterminalMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(tjactivityterminal record) {
        return tjactivityterminalMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(tjactivityterminal record) {
        return tjactivityterminalMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tjactivityterminalMapper.deleteByPrimaryKey(id);
    }
}