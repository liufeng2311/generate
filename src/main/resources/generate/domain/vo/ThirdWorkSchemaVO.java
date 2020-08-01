package com.domain.vo;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author liuF
 * @date 2020-08-01
 * @desc 工作范围VO
 */

@Data
@ApiModel(description = "工作范围VO")
public class ThirdWorkSchemaVO implements Serializable {

  @ApiModelProperty(value = "id")
  private String id;

  @ApiModelProperty(value = "第三方ID")
  private String thirdId;

  @ApiModelProperty(value = "第三方名称")
  private String thirdName;

  @ApiModelProperty(value = "开放查询开始时间")
  private Date beginDate;

  @ApiModelProperty(value = "放开查询结束时间")
  private Date endDate;

  @ApiModelProperty(value = "状态code")
  private String stateCode;

  @ApiModelProperty(value = "状态值")
  private String stateValue;

  @ApiModelProperty(value = "工作范围code")
  private String workCode;

  @ApiModelProperty(value = "工作范围")
  private String workValue;

  @ApiModelProperty(value = "必要条件code")
  private String requirement;

}

