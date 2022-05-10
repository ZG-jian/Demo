package com.jian.web.filter;

import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 在Filter中打开一个SqlSession,拦所有请求
 */
@WebFilter("/*")
public class OpenSqlSessionInViewFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            filterChain.doFilter(servletRequest, servletResponse);//放行
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }

    }

    @Override
    public void destroy() {

    }
}
