package com.generate.generate.factory;

import com.generate.generate.factory.impl.DataSource;
import com.generate.generate.factory.impl.DefaultGenerate;
import java.util.Properties;

/**
 * @Date: 2020/7/29
 * @desc 创建数据库连接
 */
public class GenerateFactory {

  public static Generate newInstance(Properties properties, DataSource dataSource, String templatePath, String outPath, String xmlPath)
      throws Exception {
    Generate generate = new DefaultGenerate(templatePath, outPath, xmlPath, properties, dataSource);
    return generate;
  }

}
