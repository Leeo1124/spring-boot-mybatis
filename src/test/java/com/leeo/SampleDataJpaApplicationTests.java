package com.leeo;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.assertj.core.api.AbstractIterableAssert;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(properties={"spring.jmx.enabled:true", "spring.datasource.jmx-enabled:true"})
@ActiveProfiles({"scratch"})
public class SampleDataJpaApplicationTests
{

  @Autowired
  private WebApplicationContext context;
  private MockMvc mvc;

  @Before
  public void setUp()
  {
    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }

  @Test
  public void testHome() throws Exception
  {
    this.mvc.perform(MockMvcRequestBuilders.get("/", new Object[0])).andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().string("Bath"));
  }

  @Test
  public void testJmx() throws Exception {
    Assertions.assertThat(ManagementFactory.getPlatformMBeanServer()
      .queryMBeans(new ObjectName("jpa.sample:type=ConnectionPool,*"), null))
      .hasSize(1);
  }
}