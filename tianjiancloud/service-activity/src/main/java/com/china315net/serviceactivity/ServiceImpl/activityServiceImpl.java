package com.china315net.serviceactivity.ServiceImpl;

import com.china315net.serviceactivity.Entity.activityall;
import com.china315net.serviceactivity.Entity.tjactivity;
import com.china315net.serviceactivity.Service.tjactivityService;
import com.china315net.serviceactivity.mapper.tjactivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class activityServiceImpl implements tjactivityService {
    @Autowired
    private tjactivityMapper activityMapper;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public tjactivity selectByPrimaryKey(Integer id) {
        return activityMapper.selectByPrimaryKey(id);
    }

//    @Override
//    public List<activityall> selectByCompid(Integer compid, Integer limit, Integer offset) {
//        return activityMapper.selectByCompid(compid, limit, offset);
//    }

//    @Override
//    public Integer getActivityCount(Integer CompID) {
//        return activityMapper.getActivityCount(CompID);
//    }

    @Override
    public Integer insertSelective(tjactivity record) {
        return activityMapper.insertSelective(record);
    }

    @Override
    public Integer updateByPrimaryKeySelective(tjactivity record) {
        return activityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return activityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<activityall> selectAllSmart(Integer compid, String filter, String sorter, Integer lmt, Integer offst) {
        String sql = "select t.*,acts.strategyname as asname,(select count(id) from tj_activity_prizes where acid=t.id) as prizenm,(select count(id) from tj_activity_product where acid=t.id) as prodnm,(select count(id) from tj_activity_agent where acid=t.id) as agentnm,(select count(id) from tj_activity_terminal where acid=t.id) as terminum from tj_activity t join tj_activity_strategy acts on t.ASID=acts.id and t.del_flag=0 " +
                (compid != null ? " and t.CompID=" + compid : "") +
                (filter != null ? filter : "") +
                (sorter != null ? " order by " + sorter : "") +
                (lmt > 0 ? " limit " + lmt : "") +
                (offst > 0 ? " offset " + offst : "");
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<activityall>(activityall.class));
    }

    @Override
    public Integer getCountByFilter(Integer compid, String filter) {
        String sql = "select count(t.id) from tj_activity t where t.del_flag=0" +
                (compid != null ? " and t.CompID=" + compid : "") +
                (filter != null ? " " + filter : "");
        return jdbcTemplate.queryForObject(sql, (Map<String, ?>) null, Integer.class);
    }
}
