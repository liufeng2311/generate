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
 * @Author: liufeng
 * @Date: 2020/7/29
 * @desc 处理File有关的操作
 */
public class FileUtils {

  /**
   * 使用(File.separator)代替路径分隔符(/)或(\),解决Windows和Mac路径不通用问题
   */
  public static String formatFilePath(String filePath) {
    String newFilePath = filePath.replace("/", File.separator)
        .replace("\\", File.separator);
    return newFilePath;
  }

  /**
   * 解析配置文件,用于模板属性替换
   */
  public static Properties ParseProperties(String propertyPath) {
    Properties properties = new Properties();
    List<File> fileList = new ArrayList<>();
    searchAllFile(new File(formatFilePath(propertyPath)), fileList);
    fileList.stream().filter(x -> x.getName().endsWith(".properties"))
        .forEach(y -> {
          try {
            properties.load(new FileInputStream(y));
          } catch (IOException e) {
            e.printStackTrace();
          }
        });
    properties.put("date", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
    return properties;
  }


  public static List<File> searchAllFile(File dir) {
    List<File> fileList = new ArrayList<>();
    searchAllFile(dir, fileList);
    return fileList;
  }

  /**
   * 获取指定路径下的所有文件searchAllFile
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
    if (dir == null) {
      throw new IllegalArgumentException("文件夹不能为null");
    }
    File resultFile = new File(dir, file);
    if (resultFile.getParentFile() != null) {
      resultFile.getParentFile().mkdirs();
    }
    return resultFile;
  }
}
