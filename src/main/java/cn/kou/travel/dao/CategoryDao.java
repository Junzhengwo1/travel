package cn.kou.travel.dao;

import cn.kou.travel.domain.Category;

import java.util.List;

/**
 * @author dell
 */
public interface CategoryDao {

    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();

}
