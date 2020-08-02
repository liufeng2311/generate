package com.generate.generate.factory;

import com.generate.generate.domain.Table;
import java.util.List;

/**
 * @Author: liufeng
 * @Date: 2020/7/29
 * @desc
 */
public interface Generate {


  /**
   * 根据模板和表信息生成文件
   *
   * @param tables 需要生成模板的表信息
   */
  void generateFile(List<Table> tables) throws Exception;


  /**
   * 拼装数据库需要的数据
   *
   * @param tableNames 需要生成的表名称
   */
  List<Table> tableData(List<String> tableNames) throws Exception;

}
