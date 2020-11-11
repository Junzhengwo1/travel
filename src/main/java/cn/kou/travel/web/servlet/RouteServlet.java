package cn.kou.travel.web.servlet;

import cn.kou.travel.domain.PageBean;
import cn.kou.travel.domain.Route;
import cn.kou.travel.service.RouteService;
import cn.kou.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dell
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService service=new RouteServiceImpl();

    public void pageQuery(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        //接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        //判断
        int cid=0;
        if(cidStr!=null && cidStr.length()>0){

            cid=Integer.parseInt(cidStr);
        }

        int currentPage=0;
        if(currentPageStr!=null && currentPageStr.length()>0){

            currentPage=Integer.parseInt(currentPageStr);
        }else {
            currentPage=1;
        }
        int pageSize=0;

        if(pageSizeStr!=null && pageSizeStr.length()>0){

            pageSize=Integer.parseInt(pageSizeStr);
        }else {
            pageSize=5;
        }

        //调用service方法查询pageBean对象
        PageBean<Route> routePageBean = service.pageQuery(cid, currentPage, pageSize);

        //将pageBean对象序列化 json
        writeValue(routePageBean,response);


    }


}
