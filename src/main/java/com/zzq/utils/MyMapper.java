package com.zzq.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zzq
 * @createTime 2018/3/26
 */
public interface MyMapper <T> extends Mapper<T>, MySqlMapper<T> {
}
