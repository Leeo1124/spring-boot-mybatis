package com.leeo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.leeo.common.mapper.MyMapper;

@EnableTransactionManagement
@ServletComponentScan
@SpringBootApplication
@MapperScan(basePackages={"com.leeo.**.mapper"}, markerInterface=MyMapper.class)
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
})
public class Application
{
  @Bean
  public Object testBean(PlatformTransactionManager platformTransactionManager)
  {
    System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
    return new Object();
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}