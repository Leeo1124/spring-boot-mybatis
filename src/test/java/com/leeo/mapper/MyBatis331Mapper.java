package com.leeo.mapper;

import com.leeo.common.mapper.MyMapper;
import com.leeo.model.City2;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public abstract interface MyBatis331Mapper extends MyMapper<City2>
{
  @Insert({"<script>insert into city (id, name, state) values <foreach collection=\"list\" item=\"city\" separator=\",\" >(#{city.id}, #{city.cityName}, #{city.cityState})</foreach></script>"})
  @Options(useGeneratedKeys=true, keyProperty="id")
  public abstract int insertCities(List<City2> paramList);

  @Results(id="cityResult", value={@org.apache.ibatis.annotations.Result(property="id", column="id", id=true), @org.apache.ibatis.annotations.Result(property="cityName", column="name", id=true), @org.apache.ibatis.annotations.Result(property="cityState", column="state", id=true)})
  @Select({"select id, name, state from city where id = #{id}"})
  public abstract City2 selectByCityId(Integer paramInteger);

  @ResultMap({"cityResult"})
  @Select({"select id, name, state from city"})
  public abstract List<City2> selectAll();
}