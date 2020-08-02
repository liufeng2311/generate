package com.generate.generate.domain;

import java.util.List;
import lombok.Data;

@Data
public class Table {

  //数据库表名
  private String jdbcName;

  //实体类类名
  private String javaName;

  //实体类类名(首字母小写)
  private String javaNameLow;

  //表注释
  private String comment;

  //表字段集合(含有ID字段)
  private List<Column> columns;

  //表字段集合(不含ID字段)
  private List<Column> columnsExcludeId;

  //字段集合(含ID,使用逗号分隔)
  private String sql;

  //是否需要引入Date
  private boolean dateFlag;

  //是否需要引入LocalDate
  private boolean localDateFlag;

  //是否需要引入JsonFormat
  private boolean jsonFormatFlag;

  //是否需要引入Object
  private boolean objectFlag;

}
