package com.generate;

import com.generate.generate.enums.ModeEnum;
import com.generate.generate.factory.DataSourceFactory;
import com.generate.generate.factory.Generate;
import com.generate.generate.factory.GenerateFactory;
import com.generate.generate.factory.impl.DataSource;
import com.generate.generate.utils.FileUtils;
import java.util.Properties;

/**
 * @Author: liufeng
 * @Date: 2020/7/29
 * @desc Mysql代码生成器
 */
public class GenerateFile {

  //模板集合路径
  public static String templatePath = System.getProperty("user.dir") + "/src/main/resources/templates/template";

  //生成文件位置(java文件)
  public static String fileOutPath = System.getProperty("user.dir") + "/src/main/java/com/generate/demo";

  //生成文件位置(xml文件)
  public static String xmlOutPath = System.getProperty("user.dir") + "/src/main/resources/mapper";

  //配置文件,指定包路径和字段转换
  public static String propertyPath = System.getProperty("user.dir") + "/src/main/resources/templates/properties";

  //数据库相关配置
  public static String url = "jdbc:mysql://106.54.84.115:3306/cases_lr?Unicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
  public static String username = "bmsoft";
  public static String password = "bmsoft@123";
  //指定生成的表
  public static String table = "third_work_schema";

  //生成模式
  public static ModeEnum mode = ModeEnum.TABLE;


  /**
   * 我们需要指定引擎模板的路径和数据库信息
   */
  public static void main(String[] args) throws Exception {
    //解析配置文件
    Properties properties = FileUtils.ParseProperties(propertyPath);
    //创建数据库连接
    DataSource dataSource = DataSourceFactory.newInstance(url, username, password);
    //设置生成器
    Generate generate = GenerateFactory.newInstance(properties, dataSource, templatePath, fileOutPath, xmlOutPath);
    //生成模板
    generate.generateFile(generate.tableData());
  }
}
