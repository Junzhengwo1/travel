package cn.kou.travel.service;

import cn.kou.travel.domain.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
