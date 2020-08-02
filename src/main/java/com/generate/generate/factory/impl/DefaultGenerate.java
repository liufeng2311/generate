package com.generate.generate.factory.impl;

import com.generate.generate.domain.Column;
import com.generate.generate.domain.Table;
import com.generate.generate.factory.Generate;
import freemarker.template.Configuration;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

public class DefaultGenerate implements Generate {

  /**
   * 参数变量
   */
  private Properties properties;

  /**
   * 数据库连接信息
   */
  private DataSource dataSource;

  /**
   * 生成逻辑实现类
   */
  private GeneratorService generatorService;

  //定义值查询表
  private String[] range = new String[]{"TABLE"};

  public DefaultGenerate(String templatePath, String outPath, String xmlPath, Properties properties,
      DataSource dataSource) throws Exception {
    this.properties = properties;
    this.dataSource = dataSource;
    this.generatorService = new GeneratorService(templatePath, outPath, xmlPath,
        new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
  }


  @Override
  public void generateFile(List<Table> tables) throws Exception {
    for (Table table : tables) {
      properties.put("table", table);
      generatorService.scanTemplatesAndProcess(properties);
    }
  }

  @Override
  public List<Table> tableData(List<String> targetTables) throws Exception {
    List<Table> tables = new ArrayList<>();
    Connection connection = dataSource.getConnection();
    DatabaseMetaData metaData = connection.getMetaData();
    parseTableInfo(metaData, tables, targetTables);
    connection.close();
    return tables;
  }

  /**
   * 设置表信息
   */
  private void parseTableInfo(DatabaseMetaData metaData, List<Table> list,
      List<String> targetTables) throws Exception {
    ResultSet tables = metaData.getTables(dataSource.schema(), null, "%", range);
    boolean allFlag = (targetTables.size() == 1 && targetTables.get(0).equals("%")) ? false : true;
    while (tables.next()) {
      String tableName = tables.getString("TABLE_NAME");
      if (allFlag && !fuzzyQuery(targetTables, tableName)) {
        continue;
      }
      Table table = new Table();
      table.setJdbcName(tableName);
      table.setComment(tables.getString("REMARKS"));
      table.setJavaName(underlineToCamel(tableName, true));
      table.setJavaNameLow(underlineToCamel(tableName, false));
      columnList(metaData, tableName, table);
      list.add(table);
    }
    tables.close();
  }

  public static void main(String[] args) {
    String aa = "%abcdef%";
    //System.out.println(aa.substring(1));
    System.out.println(aa.indexOf("%", 1));
    //System.out.println(aa.substring(0, aa.length() - 1));
  }

  /**
   * 表名模糊匹配
   */
  private boolean fuzzyQuery(List<String> list, String tableName) {
    for (String str : list) {
      if (str.equals(tableName)) {
        return true;
      }
      int length = str.length(); //表名长度
      int offset = str.indexOf("%"); //第一个索引位置
      int offsetEnd = str.indexOf("%", 1); //最后一个索引位置
      if (offset == 0 && offsetEnd == length - 1
          && tableName.indexOf(str.substring(1, length - 1)) > -1) {
        return true;
      }
      if (offset == 0 && tableName.startsWith(str.substring(1))) {
        return true;
      }
      if (offsetEnd == length - 1 && tableName.endsWith(str.substring(0, length - 1))) {
        return true;
      }
    }
    return false;
  }

  /**
   * 获取表所有字段,使用逗号分隔
   */
  private void sqlIncludeId(Table table) {
    String sqlIncludeId = table.getColumns().stream()
        .map(Column::getJdbcColumnName)
        .collect(Collectors.joining(","));
    table.setSql(sqlIncludeId);
  }

  /**
   * 获取不含ID的字段信息
   */
  private void columnsExcludeId(Table table) {
    List<Column> collect = table.getColumns().stream()
        .filter(x -> !"id".equals(x.getJdbcColumnName()))
        .collect(Collectors.toList());
    table.setColumnsExcludeId(collect);
  }

  /**
   * 主键列(联合主键存在多个主键)
   */
  private List<String> primaryKeys(DatabaseMetaData metaData, String tableName) throws Exception {
    List<String> list = new ArrayList<>();
    ResultSet primaryKeys = metaData.getPrimaryKeys(dataSource.schema(), null, tableName);
    while (primaryKeys.next()) {
      String keyName = primaryKeys.getString("COLUMN_NAME");
      list.add(keyName);
    }
    return list;
  }

  /**
   * 获取每张表的信息
   *
   * @return
   */
  private void columnList(DatabaseMetaData metaData, String tableName, Table table)
      throws Exception {
    List<String> primaryList = primaryKeys(metaData, tableName);
    List<Column> columnList = new ArrayList<>();
    ResultSet columns = metaData.getColumns(dataSource.schema(), null, tableName, null);
    while (columns.next()) {
      Column column = new Column();
      String columnName = columns.getString("COLUMN_NAME");
      String columnDbType = columns.getString("TYPE_NAME");
      String remarks = columns.getString("REMARKS");
      column.setJdbcColumnName(columnName);
      column.setJavaColumnName(underlineToCamel(columnName, false));
      column.setJdbcColumnType(columnDbType);
      String javaType = properties.getProperty(columnDbType);
      column.setColumnComment(StringUtils.isEmpty(remarks) ? columnName : remarks);
      column.setPrimaryKey(primaryList.contains(columnName) ? true : false);
      javaTypeHandler(javaType, table, column);
      columnList.add(column);
    }
    columns.close();
    table.setColumns(columnList);
    sqlIncludeId(table);
    columnsExcludeId(table);
  }

  /**
   * 判断实体类类型以及需要引进的类
   */
  private void javaTypeHandler(String javaType, Table table, Column column) {
    //设置类型
    if (javaType == null) {
      column.setJavaColumnType("Object");
      table.setObjectFlag(true);
    } else {
      column.setJavaColumnType(javaType);
    }
    //判断是否需要引入相关类
    if ("Date".equals(javaType)) {
      table.setDateFlag(true);
      table.setJsonFormatFlag(true);
      column.setDate(true);
    } else if ("LocalDate".equals(javaType)) {
      table.setLocalDateFlag(true);
      table.setJsonFormatFlag(true);
      column.setDate(true);
    }
    //判断是否为字符串
    if ("String".equals(javaType)) {
      column.setString(true);
    }
  }

  /**
   * 下划线转驼峰 upper=true表示首字母大写
   */
  private String underlineToCamel(String text, boolean upper) {
    StringBuilder builder = new StringBuilder();
    char[] src = text.toCharArray();
    int offset = 0;
    int start = text.indexOf("_");
    while (start > -1) {
      src[start + 1] = Character.toUpperCase(src[start + 1]);
      builder.append(src, offset, start - offset);
      offset = start + 1;
      start = text.indexOf("_", offset);
    }
    if (offset <= src.length) {
      builder.append(src, offset, src.length - offset);
    }
    String str = builder.toString();
    if (upper) {
      str = str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    return str;
  }

}
