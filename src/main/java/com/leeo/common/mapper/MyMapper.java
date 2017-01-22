package com.leeo.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public abstract interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>
{
}