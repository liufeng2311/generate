package com.generate;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.generate.generate.factory.DataSourceFactory;
import com.generate.generate.factory.Generate;
import com.generate.generate.factory.GenerateFactory;
import com.generate.generate.factory.impl.DataSource;
import com.generate.generate.utils.FileUtils;

/**
 * @desc Mysql代码生成器
 */
public class GenerateFile {

  //项目路径
  private static final String projectPath = System.getProperty("user.dir");

  //java文件路径
  private static final String javaPath = projectPath + "/src/main/java";

  //resources文件路径
  private static final String resourcesPath = projectPath + "/src/main/resources";

  //模板文件路径
  private static String templatePath = resourcesPath + "/templates/template";

  //生成java文件路径
  private static String fileOutPath = javaPath + "/com/generate/demo";

  //生成xml文件路径
  private static String xmlOutPath = resourcesPath + "/mapper";

  //配置文件路径
  private static String propertyPath = resourcesPath + "/templates/properties";

  //数据库相关配置
  private static String url = "jdbc:mysql://localhost:3306/test4?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useAffectedRows=true&connectTimeout=6000&socketTimeout=3000";
  private static String username = "root";
  private static String password = "admin";
  //数据库名
  private static String schema = "test4";

  //指定生成的表
  static List<String> tables = Arrays.asList("user");
  //public static List<String> tables = Arrays.asList("%mem%","%mem","mem%"); //模糊匹配生成
  //public static List<String> tables = Arrays.asList("%");  //生成所有表

  static {
    templatePath = FileUtils.formatFilePath(templatePath);
    fileOutPath = FileUtils.formatFilePath(fileOutPath);
    xmlOutPath = FileUtils.formatFilePath(xmlOutPath);
    propertyPath = FileUtils.formatFilePath(propertyPath);
  }


  /**
   * 我们需要指定引擎模板的路径和数据库信息
   */
  public static void main(String[] args) throws Exception {
    //解析配置文件
    Properties properties = FileUtils.ParseProperties(propertyPath);
    //创建数据库连接
    DataSource dataSource = DataSourceFactory.newInstance(url, username, password, schema);
    //设置生成器
    Generate generate = GenerateFactory
      .newInstance(properties, dataSource, templatePath, fileOutPath, xmlOutPath);
    //生成模板
    generate.generateFile(generate.tableData(tables));
  }
}
