package com.sgy.bookstore.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //获得要执行的方法名
        String methodName = request.getParameter("act");

        //如果用户没有提供方法名，使用默认方法
        if(methodName == null || methodName.equals("")){
            //默认方法
            methodName = "execute";
        }

        Method method;
        try{
            //在对象中获得类型信息，在类型中通过方法名与参数类型获得方法
            method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //在当前对象中调用方法
            String targetUri = method.invoke(this, request, response) + "";
            //如果url返回的是以redirect开始，则为重定向
            if(targetUri.startsWith("redirect:")){
                response.sendRedirect(targetUri.substring(9, targetUri.length()));
            }else{
                //转发
                request.getRequestDispatcher(targetUri).forward(request, response);
            }
        }catch(Exception e){
            response.sendError(400, e.getMessage());
            e.printStackTrace();
        }
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.sendError(400, "请使用参数指定您要访问的方法");
    }
}
