package com.ruoyi.web.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.filter
 * @ClassName: 判断用户是否登录
 * @Author: 胡天霸
 * @Date: 2020/5/2 11:32
 * @Version: 1.0
 */
@WebFilter(filterName = "userFilter",urlPatterns = {"/learning"})
public class UserFilter implements Filter {

    //返回值
    String NO_LOGIN= "没有权限！！";

    //不过滤的url
    String[] Urls = new String[]{"/learning","/learning/main","/learning/login","/learning/judgeUser"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        System.out.println("filter url:"+uri);
        //是否需要过滤
        boolean filterUrl = isUrlFilter(uri);

        if (!filterUrl) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if(session!=null&&session.getAttribute("user") != null){
                // System.out.println("user:"+session.getAttribute("user"));
                filterChain.doFilter(request, response);
            }else{
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
                    response.getWriter().write(this.NO_LOGIN);
                }else{
                    //重定向到首页
                    response.sendRedirect(request.getContextPath()+"/learning");
                }
                return;
            }
        }
    }

    /**
     *  判断是否拦截
     * @param url
     * @return
     */
    public boolean isUrlFilter(String url) {
        for (String a : Urls) {
            if(a.equals(url)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void destroy() {

    }
}
