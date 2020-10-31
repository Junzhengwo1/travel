package cn.kou.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dell
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    public void pageQuery(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        //接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");



    }


}
