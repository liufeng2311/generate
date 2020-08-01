package com.generate.generate.factory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: liufeng
 * @Date: 2020/7/29
 * @desc
 */
public class DataSource {

  /**
   * 数据路链接
   */
  private String url;

  /**
   * 数据库驱动
   */
  private String driver = "com.mysql.cj.jdbc.Driver";

  /**
   * 用户名
   */
  private String username;

  /**
   * 密码
   */
  private String password;

  public DataSource(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  /**
   * 获取Connection
   * @return
   */
  public Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(driver);
    Properties props = new Properties();
    props.put("remarks", "true");
    props.put("useInformationSchema", "true");
    props.put("user", username);
    props.put("password", password);
    Connection conn = DriverManager.getConnection(url, props);
    return conn;
  }

}
