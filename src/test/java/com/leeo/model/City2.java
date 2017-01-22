package com.leeo.model;

public class City2
{
  private Integer id;
  private String cityName;
  private String cityState;

  public City2()
  {
  }

  public City2(String cityName, String cityState)
  {
    this.cityName = cityName;
    this.cityState = cityState;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCityName() {
    return this.cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCityState() {
    return this.cityState;
  }

  public void setCityState(String cityState) {
    this.cityState = cityState;
  }

  public String toString()
  {
    return "City2{id=" + this.id + ", cityName='" + this.cityName + '\'' + ", cityState='" + this.cityState + '\'' + '}';
  }
}