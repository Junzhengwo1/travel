package cn.kou.travel.dao.impl;

import cn.kou.travel.dao.RouteDao;
import cn.kou.travel.domain.Route;
import cn.kou.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author JIAJUN KOU
 */
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public int findTotalCount(int cid) {
        //定义sql
        String sql="select count(*) from tab_route where cid=?";
        //执行

        return template.queryForObject(sql,Integer.class,cid);
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize) {

        String sql="select * from tab_route where cid=? limit ? ,?" ;

        return template.query(sql ,new BeanPropertyRowMapper<Route>(Route.class),cid,start,pageSize);
    }
}
