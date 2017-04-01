package com.leeo.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="myFilter", urlPatterns={"/*"})
public class MyFilter implements Filter
{
  public void destroy()
  {
    System.out.println("过滤器销毁");
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    System.out.println("执行过滤操作");
    chain.doFilter(request, response);
  }

  public void init(FilterConfig config) throws ServletException
  {
    System.out.println("过滤器初始化");
  }
}