package com.leeo.web.mapper;

import com.leeo.common.mapper.MyMapper;
import com.leeo.web.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public abstract interface CityMapper extends MyMapper<City>
{
  @Select({"select * from city where state = #{state}"})
  public abstract City findByState(@Param("state") String paramString);
}