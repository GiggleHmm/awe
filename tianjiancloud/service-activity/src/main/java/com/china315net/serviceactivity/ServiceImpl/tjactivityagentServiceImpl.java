package com.china315net.serviceactivity.ServiceImpl;
import com.china315net.serviceactivity.Entity.tjactivityagent;
import com.china315net.serviceactivity.Service.tjactivityagentService;
import com.china315net.serviceactivity.mapper.tjactivityagentMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class tjactivityagentServiceImpl implements tjactivityagentService {
    @Autowired
    private tjactivityagentMapper tjactivityagentMapper;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public Integer gettjactivityagentcountbyacid(Integer acid) {
        return tjactivityagentMapper.gettjactivityagentcountbyacid(acid);
    }
    @Override
    public List<tjactivityagent> gettjactivityagentbyacid(Integer compid, Integer limit, Integer offset) {
        return tjactivityagentMapper.gettjactivityagentbyacid(compid,limit,offset);
    }
    @Override
    public tjactivityagent selectByPrimaryKey(Integer id) {
        return tjactivityagentMapper.selectByPrimaryKey(id);
    }
    @Override
    public int updateByPrimaryKeySelective(tjactivityagent record) {
        return tjactivityagentMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int insertSelective(tjactivityagent record) {
        return tjactivityagentMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tjactivityagentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<tjactivityagent> selectAllSmart(Integer compid, String filter, String sorter, Integer lmt, Integer offst) {
        String sql = "select t.* tjactivityagent t t.del_flag=0 " +
                (compid != null ? " and t.CompID=" + compid : "") +
                (filter != null ? filter : "") +
                (sorter != null ? " order by " + sorter : "") +
                (lmt > 0 ? " limit " + lmt : "") +
                (offst > 0 ? " offset " + offst : "");
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<tjactivityagent>(tjactivityagent.class));
    }
    @Override
    public Integer getCountByFilter(Integer compid, String filter) {
        String sql = "select count(t.id) from tjactivityagent t where t.del_flag=0" +
                (compid != null ? " and t.CompID=" + compid : "") +
                (filter != null ? " " + filter : "");
        return jdbcTemplate.queryForObject(sql, (Map<String, ?>) null, Integer.class);
    }

}
