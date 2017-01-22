package com.leeo.web.listener;

import java.io.PrintStream;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener
  implements HttpSessionListener
{
  public void sessionCreated(HttpSessionEvent se)
  {
    System.out.println("Session 被创建");
  }

  public void sessionDestroyed(HttpSessionEvent se)
  {
    System.out.println("ServletContex初始化");
  }
}