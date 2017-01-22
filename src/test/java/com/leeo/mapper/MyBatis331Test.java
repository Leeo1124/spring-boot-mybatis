package com.leeo.mapper;

import com.leeo.model.City2;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest
public class MyBatis331Test
{
  private Logger logger = LoggerFactory.getLogger(super.getClass());

  @Autowired
  private MyBatis331Mapper mapper;

  @Test
  @Rollback
  public void testInsertList()
  {
    List<City2> city2List = new ArrayList<>();
    city2List.add(new City2("石家庄", "河北"));
    city2List.add(new City2("邯郸", "河北"));
    city2List.add(new City2("秦皇岛", "河北"));
    Assert.assertEquals(3L, this.mapper.insertCities(city2List));
    for (City2 c2 : city2List) {
      this.logger.info(c2.toString());
      Assert.assertNotNull(c2.getId());
    }
  }

  @Test
  public void testSelectById() {
    City2 city2 = this.mapper.selectByCityId(Integer.valueOf(1));
    this.logger.info(city2.toString());
    Assert.assertNotNull(city2);
    Assert.assertNotNull(city2.getCityName());
    Assert.assertNotNull(city2.getCityState());
  }

  @Test
  public void testSelectAll() {
    List<City2> city2List = this.mapper.selectAll();
    for (City2 c2 : city2List) {
      this.logger.info(c2.toString());
      Assert.assertNotNull(c2);
      Assert.assertNotNull(c2.getCityName());
      Assert.assertNotNull(c2.getCityState());
    }
  }
}