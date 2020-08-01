package com.generate.generate.enums;

/**
 * @Author: liufeng
 * @Date: 2020/7/29
 * @desc 模板生成模式
 */
public enum ModeEnum {

  PRODUCT("模块"),
  TABLE("表");

  private String desc;

  ModeEnum(String desc) {
    this.desc = desc;
  }

}
