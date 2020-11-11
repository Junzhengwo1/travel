package cn.kou.travel.service;

import cn.kou.travel.domain.PageBean;
import cn.kou.travel.domain.Route;

/**
 * @author dell
 */
public interface RouteService {

    /**
     * 分页查询。
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize);
}
