package com.leeo.web.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/xs/myservlet"}, description="Servlet的说明")
public class MyServlet2 extends HttpServlet
{
  private static final long serialVersionUID = -8685285401859800066L;

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    System.out.println(">>>>>>>>>>doGet2()<<<<<<<<<<<");
    doPost(req, resp);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    System.out.println(">>>>>>>>>>doPost2()<<<<<<<<<<<");
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Hello World</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>大家好，我的名字叫Servlet2</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}