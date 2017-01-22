package com.leeo.web.listener;

import java.io.PrintStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener
  implements ServletContextListener
{
  public void contextInitialized(ServletContextEvent sce)
  {
    System.out.println("ServletContex初始化");
    System.out.println(sce.getServletContext().getServerInfo());
  }

  public void contextDestroyed(ServletContextEvent sce)
  {
    System.out.println("ServletContex销毁");
  }
}