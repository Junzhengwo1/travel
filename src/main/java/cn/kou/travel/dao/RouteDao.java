package cn.kou.travel.dao;

import cn.kou.travel.domain.Route;

import java.util.List;

/**
 * @author dell
 */
public interface RouteDao {

    /**
     * 根据cid查询总记录数
     * @param cid
     * @return
     */
    public int findTotalCount(int cid);

    /**
     * 根据cid，start，pageSize查询当前页的数据
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid,int start,int pageSize);

}
