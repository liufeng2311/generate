package com.generate.generate.domain;

import lombok.Data;

@Data
public class Column {

  //列名称
  private String jdbcColumnName;

  //名称对应实体类字段
  private String javaColumnName;

  //列类型
  private String jdbcColumnType;

  //列类型对应实体类字段
  private String javaColumnType;

  //备注
  private String columnComment;

  //是否为主键
  private boolean primaryKey;

  //是否为字符串
  private boolean string;

  //是否为日期类型
  private boolean date;

}
