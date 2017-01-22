package com.leeo.config;

import com.leeo.web.interceptor.MyInterceptor1;
import com.leeo.web.interceptor.MyInterceptor2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter
  implements EnvironmentAware
{
  private static final Logger logger = LoggerFactory.getLogger(MyWebAppConfig.class);
  private RelaxedPropertyResolver propertyResolver;

  @Value("${spring.datasource.url}")
  private String myUrl;

  public void addInterceptors(InterceptorRegistry registry)
  {
    registry.addInterceptor(new MyInterceptor1()).addPathPatterns(new String[] { "/**" });
    registry.addInterceptor(new MyInterceptor2()).addPathPatterns(new String[] { "/**" });
    super.addInterceptors(registry);
  }

  public void setEnvironment(Environment env)
  {
    logger.info(env.getProperty("JAVA_HOME"));
    logger.info(this.myUrl);
    String str = env.getProperty("spring.datasource.url");
    logger.info(str);
    this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    String url = this.propertyResolver.getProperty("url");
    logger.info(url);
  }
}