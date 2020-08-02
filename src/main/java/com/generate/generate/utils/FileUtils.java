package com.generate.generate.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @desc 处理File有关的操作
 */
public class FileUtils {

  /**
   * 使用(File.separator)代替路径分隔符
   */
  public static String formatFilePath(String filePath) {
    String path = filePath.replace("/", File.separator);
    String newPath = path.replace("\\", File.separator);
    return newPath;
  }

  /**
   * 解析配置文件,用于模板属性替换
   */
  public static Properties ParseProperties(String propertyPath) throws IOException {
    Properties properties = new Properties();
    List<File> fileList = searchAllFile(new File(propertyPath));
    for (File file : fileList) {
      if (file.getName().endsWith(".properties")) {
        properties.load(new FileInputStream(file));
      }
    }
    properties.put("date", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
    return properties;
  }


  /**
   * 获取指定路径下的所有文件
   */
  public static List<File> searchAllFile(String filePath) {
    return searchAllFile(new File(filePath));
  }

  /**
   * 获取指定路径下的所有文件
   */
  public static List<File> searchAllFile(File dir) {
    List<File> fileList = new ArrayList<>();
    searchAllFile(dir, fileList);
    return fileList;
  }

  /**
   * 获取指定路径下的所有文件
   */
  private static void searchAllFile(File dir, List<File> fileList) {
    if (dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (int i = 0; i < files.length; i++) {
        searchAllFile(files[i], fileList);
      }
    } else {
      fileList.add(dir);
    }
  }

  /**
   * 创建文件夹
   *
   * @return
   */
  public static File mkdir(String dir, String file) {
    File resultFile = new File(dir, file);
    if (resultFile.getParentFile() != null) {
      resultFile.getParentFile().mkdirs();
    }
    return resultFile;
  }

  /**
   * 创建文件夹
   *
   * @return
   */
  public static File mkdir(String filePath) {
    File resultFile = new File(filePath);
    if (resultFile.getParentFile() != null) {
      resultFile.getParentFile().mkdirs();
    }
    return resultFile;
  }
}
