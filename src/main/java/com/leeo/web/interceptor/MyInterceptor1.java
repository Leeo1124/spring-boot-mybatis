package com.leeo.web.interceptor;

import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor1
  implements HandlerInterceptor
{
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception
  {
    System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");

    return true;
  }

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    throws Exception
  {
    System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
  }

  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    throws Exception
  {
    System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
  }
}