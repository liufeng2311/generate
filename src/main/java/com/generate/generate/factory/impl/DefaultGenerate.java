package com.generate.generate.factory.impl;

import com.generate.GenerateFile;
import com.generate.generate.domain.Column;
import com.generate.generate.domain.Table;
import com.generate.generate.enums.ModeEnum;
import com.generate.generate.factory.Generate;
import freemarker.template.Configuration;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
   * 表名
   */
  private String tables = GenerateFile.table;

  /**
   * 数据库名
   */
  private String scheme;

  private GeneratorService generator;

  List<Table> tableList = new ArrayList<>();

  //定义值查询表
  private String[] range = new String[]{"TABLE"};

  public DefaultGenerate(String templatePath, String outPath, String xmlPath, Properties properties,
      DataSource dataSource) throws Exception {
    this.properties = properties;
    this.dataSource = dataSource;
    this.scheme = this.properties.getProperty("scheme");
    this.generator = new GeneratorService(templatePath, outPath, xmlPath,
        new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
  }


  /**
   * 设置表信息
   */
  private void parseTableInfo(DatabaseMetaData metaData, List<Table> list) throws SQLException {
    List<String> split = Arrays.asList(tables.split(","));
    ResultSet tables = metaData.getTables(scheme, "", "%", range);
    while (tables.next()) {
      String tableName = tables.getString("TABLE_NAME");
      if (GenerateFile.mode == ModeEnum.TABLE && !split.contains(tableName)) {
        continue;
      }
      Table table = new Table();
      table.setJdbcName(tableName);
      table.setJavaName(underlineToCamel(tableName, true));
      table.setJavaNameLow(underlineToCamel(tableName, false));
      table.setComment(tables.getString("REMARKS"));
      List<String> primaryList = primaryKeys(metaData, tableName);
      table.setColumns(columnList(metaData, tableName, primaryList));
      String Sql = table.getColumns().stream().map(Column::getJdbcColumnName)
          .collect(Collectors.joining(","));
      table.setSql(Sql);
      List<Column> collect = table.getColumns().stream()
          .filter(x -> !"id".equals(x.getJdbcColumnName())).collect(
              Collectors.toList());
      table.setColumnsExcludeId(collect);
      list.add(table);
    }
    tables.close();
  }

  /**
   * 主键列(联合主键存在多个主键)
   */
  private List<String> primaryKeys(DatabaseMetaData metaData, String tableName)
      throws SQLException {
    List<String> list = new ArrayList<>();
    ResultSet primaryKeys = metaData.getPrimaryKeys(null, scheme, tableName);
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
  private List<Column> columnList(DatabaseMetaData metaData, String tableName,
      List<String> primaryList) throws SQLException {
    List<Column> columnList = new ArrayList<>();
    ResultSet columns = metaData.getColumns(null, scheme, tableName, null);
    while (columns.next()) {
      Column column = new Column();
      String columnName = columns.getString("COLUMN_NAME");
      column.setJdbcColumnName(columnName);
      column.setJavaColumnName(underlineToCamel(columnName, false));
      String columnDbType = columns.getString("TYPE_NAME");
      column.setJdbcColumnType(columnDbType);
      String javaType = properties.getProperty(columnDbType);
      if ("Date".equals(javaType)) {
        properties.put("dateFlag", "true");
        properties.put("jsonFormatFlag", "true");
        column.setDate(true);
      } else if ("LocalDate".equals(javaType)) {
        properties.put("localDateFlag", "true");
        properties.put("jsonFormatFlag", "true");
        column.setDate(true);
      }
      if ("String".equals(javaType)) {
        column.setString(true);
      }
      column.setJavaColumnType(javaType == null ? "Object" : javaType);
      String remarks = columns.getString("REMARKS");
      column.setColumnComment(StringUtils.isEmpty(remarks) ? columnName : remarks);
      column.setPrimaryKey(primaryList.contains(columnName) ? true : false);
      columnList.add(column);
    }
    columns.close();
    return columnList;

  }

  /**
   * 下划线转驼峰 true 表转实体 第一个字母大写 false 字段 第一个字母小写
   */
  public static String underlineToCamel(String param, Boolean isClass) {
    if (param == null || "".equals(param.trim())) {
      return "";
    }
    int len = param.length();
    StringBuilder sb = new StringBuilder(len);
    Boolean flag = false;
    // "_" 后转大写标志,默认字符前面没有"_"
    for (int i = 0; i < len; i++) {
      char c = param.charAt(i);
      if (c == '_') {
        flag = true;
        //标志设置为true,跳过
        continue;
      } else {
        if (flag) {
          //表示当前字符前面是"_" ,当前字符转大写
          sb.append(Character.toUpperCase(param.charAt(i)));
          //重置标识
          flag = false;
        } else {
          sb.append(Character.toLowerCase(param.charAt(i)));
        }
      }
    }
    if (isClass) {
      String preChat = sb.toString().substring(0, 1);
      return sb.toString().replaceFirst(preChat, preChat.toUpperCase());
    } else {
      return sb.toString();
    }
  }

  @Override
  public void generateFile(List<Table> tables) throws Exception {
    for (Table table : tables) {
      properties.put("table", table);
      generator.scanTemplatesAndProcess(properties);
    }
  }

  @Override
  public List<Table> tableData() throws SQLException, ClassNotFoundException {
    List<Table> tables = new ArrayList<>();
    Connection connection = dataSource.getConnection();
    DatabaseMetaData metaData = connection.getMetaData();
    parseTableInfo(metaData, tables);
    connection.close();
    return tables;
  }
}
