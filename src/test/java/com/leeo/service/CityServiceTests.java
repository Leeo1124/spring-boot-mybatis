package com.leeo.service;

import com.leeo.web.entity.City;
import com.leeo.web.service.CityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
public class CityServiceTests
{
  private Logger logger = LoggerFactory.getLogger(super.getClass());

  @Autowired
  private CityService cityService;

  @Test
  @Rollback
  public void getById()
  {
    City city = this.cityService.getById(Integer.valueOf(1));
    this.logger.info(city.toString());
    Assert.assertNotNull(city);
    Assert.assertNotNull(city.getName());
  }
}