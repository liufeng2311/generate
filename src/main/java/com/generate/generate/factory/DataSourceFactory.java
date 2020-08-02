package com.generate.generate.factory;


import com.generate.generate.factory.impl.DataSource;

/**
 * @Author: liufeng
 * @Date: 2020/7/29
 * @desc 创建数据库连接
 */
public class DataSourceFactory {

  public static DataSource newInstance(String url, String username, String password, String schema) {
    DataSource dataSource = new DataSource(url, username, password, schema);
    return dataSource;
  }

}
