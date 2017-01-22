package com.leeo.web.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

public class BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="Id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Transient
  private Integer page = Integer.valueOf(1);

  @Transient
  private Integer rows = Integer.valueOf(10);

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPage() {
    return this.page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getRows() {
    return this.rows;
  }

  public void setRows(Integer rows) {
    this.rows = rows;
  }
}