package com.leeo.web.entity;

public class City extends BaseEntity
{
  private static final long serialVersionUID = 1L;
  private String name;
  private String state;
  private String country;

  public String getName()
  {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String toString()
  {
    return getId() + "," + getName() + "," + getState() + "," + getCountry();
  }
}