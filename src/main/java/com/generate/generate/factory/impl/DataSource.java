package com.generate.generate.factory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataSource {

  /**
   * 数据路url
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

  /**
   * 数据库名
   */
  private String schema;

  public DataSource(String url, String username, String password, String schema) {
    this.url = url;
    this.username = username;
    this.password = password;
    this.schema = schema;
  }

  /**
   * 获取Connection
   *
   * @return
   */
  public Connection getConnection() throws Exception {
    Class.forName(driver);
    Properties props = new Properties();
    props.put("remarks", "true");
    props.put("useInformationSchema", "true");
    props.put("user", username);
    props.put("password", password);
    Connection conn = DriverManager.getConnection(url, props);
    return conn;
  }

  public String schema() {
    return this.schema;
  }

}
