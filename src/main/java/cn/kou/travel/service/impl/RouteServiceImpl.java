package cn.kou.travel.service.impl;

import cn.kou.travel.dao.RouteDao;
import cn.kou.travel.dao.impl.RouteDaoImpl;
import cn.kou.travel.domain.PageBean;
import cn.kou.travel.domain.Route;
import cn.kou.travel.service.RouteService;

import java.util.List;

/**
 * @author JIAJUN KOU
 */
public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao=new RouteDaoImpl();


    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {
        //封装PageBean
        PageBean<Route> pb=new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        int totalCount = routeDao.findTotalCount(cid);

        System.out.println("每页总条数："+totalCount);
        //设置总记录数
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start=(currentPage-1)*pageSize; //开始的记录数
        System.out.println("开始页码"+start);

        List<Route> list = routeDao.findByPage(cid, start, pageSize);
        pb.setList(list);
        //设置总页数
        int totalPage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1;
        System.out.println("总页数"+totalPage);
        pb.setTotalPage(totalPage);

        return pb;
    }
}
