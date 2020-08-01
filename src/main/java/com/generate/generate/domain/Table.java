package com.generate.generate.domain;

import java.util.List;
import lombok.Data;


@Data
public class Table {

  //表名
  private String jdbcName;

  //实体类表名
  private String javaName;

  //实体类名引用(首字母小写)
  private String javaNameLow;

  //表注释
  private String comment;

  //表字段集合
  private List<Column> columns;

  //表字段集合(不含ID字段)
  private List<Column> columnsExcludeId;

  //字段集合
  private String sql;

}
