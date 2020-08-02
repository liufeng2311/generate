package com.generate.generate.factory.impl;

import com.generate.generate.utils.FileUtils;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @author
 */
@Service
public class GeneratorService {

  /**
   * 模板所在路径
   */
  private String templatePath;

  /**
   * 代码生成路径
   */
  private String outPath;

  /**
   * xml生成路径
   */
  private String xmlPath;

  /**
   * 配置类
   */
  private Configuration conf;

  public GeneratorService(String templatePath, String outPath, String xmlPath, Configuration conf)
      throws IOException {
    this.templatePath = templatePath;
    this.outPath = outPath;
    this.xmlPath = xmlPath;
    this.conf = conf;
    //此处指定模板的总路径,后续获取模板使用都是相对路径,不指定依旧需要在项目路径上使用相对路径
    this.conf.setTemplateLoader(new FileTemplateLoader(new File(templatePath)));
    this.conf.setOutputEncoding("UTF-8");
  }

  public GeneratorService() {
  }

  /**
   * 扫描所有模板并进行代码生成
   */
  public void scanTemplatesAndProcess(Map data) throws Exception {
    List<File> files = FileUtils.searchAllFile(templatePath);
    for (File file : files) {
      executeGenerate(data, file);
    }
  }

  /**
   * 创建文件模板并执行
   */
  private void executeGenerate(Map data, File file) throws Exception {
    //获取文件路径(相对于TemplateLoader的路径,读取模板使用)
    String templateFile = file.getAbsolutePath().replace(templatePath, "");
    Template template = conf.getTemplate(templateFile);
    String filePath = templateFile.endsWith(".xml") ? xmlPath : outPath;
    String fileName = processTemplateString(templateFile, data);
    fileName = fileName.endsWith(".xml") ? fileName.replace("resources", ""):fileName;
    File outFile = FileUtils.mkdir(filePath, fileName);
    FileWriter fileWriter = new FileWriter(outFile);
    template.process(data, fileWriter);
    fileWriter.close();
  }

  /**
   * 创建字符串模板并执行
   */
  private String processTemplateString(String templateString, Map data) throws Exception {
    StringWriter out = new StringWriter();
    Template template = new Template("template", new StringReader(templateString), conf);
    template.process(data, out);
    return out.toString();
  }
}
