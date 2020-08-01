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
    conf.setTemplateLoader(new FileTemplateLoader(new File(templatePath)));
  }

  public GeneratorService() {
  }

  /**
   * 扫描所有模板并进行代码生成
   */
  public void scanTemplatesAndProcess(Map dataMap) throws Exception {
    //加载文件夹下的所有模板文件
    List<File> srcFiles = FileUtils.searchAllFile(new File(templatePath));
    //针对每一个模板文件进行代码生成
    for (File srcFile : srcFiles) {
      executeGenerate(dataMap, srcFile);
    }
  }

  /**
   * 对某个模板生成代码
   */
  private void executeGenerate(Map dataMap, File srcFile) throws Exception {
    //获取文件路径
    String templateFile = srcFile.getAbsolutePath()
        .replace(this.templatePath, "");
    //对文件名称进行处理(字符串替换)
    String outputFilepath = processTemplateString(templateFile, dataMap);
    //读取模板
    Template template = conf.getTemplate(templateFile);
    template.setOutputEncoding("UTF-8");
    String targetFile;
    if (templateFile.endsWith(".xml")) {
      targetFile = xmlPath;
      outputFilepath = outputFilepath.replace("resources", "");
    } else {
      targetFile = outPath;
    }
    //创建文件
    File outFile = FileUtils.mkdir(targetFile, outputFilepath);
    //模板生成
    FileWriter fileWriter = new FileWriter(outFile);
    template.process(dataMap, fileWriter);
    fileWriter.close();
  }

  /**
   * 处理字符串模板
   */
  private String processTemplateString(String templateString, Map dataMap) throws
      Exception {
    StringWriter out = new StringWriter();
    Template template = new Template("demo", new StringReader(templateString), conf);
    template.process(dataMap, out);
    return out.toString();
  }
}
