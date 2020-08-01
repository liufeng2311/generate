package com.generate.generate.factory;


import com.generate.generate.factory.impl.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @Author: liufeng
 * @Date: 2020/7/29
 * @desc 创建数据库连接
 */
public class DataSourceFactory {

  private final static Logger log = LoggerFactory.getLogger(DataSourceFactory.class);

  public static DataSource newInstance(String url, String username, String password) {
    if (StringUtils.isEmpty(url)) {
      log.error("数据库url为空");
    }
    if (StringUtils.isEmpty(username)) {
      log.error("数据库username为空");
    }
    if (StringUtils.isEmpty(password)) {
      log.error("数据库password为空");
    }
    DataSource dataSource = new DataSource(url, username, password);
    return dataSource;
  }

}
