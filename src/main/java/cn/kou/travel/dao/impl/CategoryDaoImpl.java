package cn.kou.travel.dao.impl;

import cn.kou.travel.dao.CategoryDao;
import cn.kou.travel.domain.Category;
import cn.kou.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author JIAJUN KOU
 */
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Category> findAll() {
        //1.定义sql
        String sql="select *from tab_category";

        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }
}
