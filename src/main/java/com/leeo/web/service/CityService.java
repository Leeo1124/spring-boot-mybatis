package com.leeo.web.service;

import com.github.pagehelper.PageHelper;
import com.leeo.web.entity.City;
import com.leeo.web.mapper.CityMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService
{

  @Autowired
  private CityMapper cityMapper;

  public List<City> getAll(City city)
  {
    if ((city.getPage() != null) && (city.getRows() != null))
      PageHelper.startPage(city.getPage().intValue(), city.getRows().intValue());

    return this.cityMapper.selectAll();
  }

  public City getById(Integer id) {
    return ((City)this.cityMapper.selectByPrimaryKey(id));
  }

  public void deleteById(Integer id) {
    this.cityMapper.deleteByPrimaryKey(id);
  }

  public void save(City country) {
    if (country.getId() != null)
      this.cityMapper.updateByPrimaryKey(country);
    else
      this.cityMapper.insert(country);
  }
}