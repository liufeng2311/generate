package com.generate.demo.domain.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * @author liu
 * @date 2020-08-04
 * @desc 
 */

@Data
public class ApproveSendDept implements Serializable {

  /**
   * id
   */
  private String id;

  /**
   * 单位名称
   */
  private String deptName;

  /**
   * 单位编号
   */
  private String deptNo;

  /**
   * 区域code
   */
  private String areaCode;

  /**
   * 区域名称
   */
  private String areaValue;

  /**
   * 是否可用
   */
  private String state;

  /**
   * 管理人员联系方式
   */
  private String adminTel;

  /**
   * 管理人员姓名
   */
  private String adminName;

  /**
   * 备注
   */
  private String remarks;

  /**
   * 父级ID
   */
  private String pid;

}
