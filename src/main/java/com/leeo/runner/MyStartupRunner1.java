package com.leeo.runner;

import java.io.PrintStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MyStartupRunner1
  implements CommandLineRunner
{
  public void run(String[] args)
    throws Exception
  {
    System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 11111111 <<<<<<<<<<<<<");
  }
}