package cn.kou.travel.web.servlet;


import cn.kou.travel.domain.Category;
import cn.kou.travel.service.CategoryService;
import cn.kou.travel.service.impl.CategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author dell
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service=new CategoryServiceImpl();

    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用service，查询所有
        List<Category> categories = service.findAll();

        //2.序列化json返回
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getOutputStream(),categories);
        writeValue(categories,response);

    }

}










