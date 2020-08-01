package com.domain.entity;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 * @author liuF
 * @date 2020-08-01
 * @desc 工作范围
 */

@Data
public class ThirdWorkSchema implements Serializable {

  /**
   * id
   */
  private String id;

  /**
   * 第三方ID
   */
  private String thirdId;

  /**
   * 第三方名称
   */
  private String thirdName;

  /**
   * 开放查询开始时间
   */
  private Date beginDate;

  /**
   * 放开查询结束时间
   */
  private Date endDate;

  /**
   * 状态code
   */
  private String stateCode;

  /**
   * 状态值
   */
  private String stateValue;

  /**
   * 工作范围code
   */
  private String workCode;

  /**
   * 工作范围
   */
  private String workValue;

  /**
   * 必要条件code
   */
  private String requirement;

}
