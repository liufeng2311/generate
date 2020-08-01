package com.generate.generate.factory;

import com.generate.generate.domain.Table;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: liufeng
 * @Date: 2020/7/29
 * @desc
 */
public interface Generate {


  /**
   * 根据模板生成文件
   */
  void generateFile(List<Table> tables) throws Exception;


  /**
   * 拼装数据库需要的数据
   */
  List<Table> tableData() throws SQLException, ClassNotFoundException;

}
