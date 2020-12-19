package com.generate.demo.domain.dto;

import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author liu
 * @date 2020-08-04
 * @desc DTO
 */

@Data
@ApiModel(description = "DTO")
public class ApproveReceiveDeptDTO implements Serializable {

  @ApiModelProperty(value = "id")
  private String id;

  @ApiModelProperty(value = "单位名称")
  private String deptName;

  @ApiModelProperty(value = "单位编号")
  private String deptNo;

  @ApiModelProperty(value = "区域code")
  private String areaCode;

  @ApiModelProperty(value = "区域名称")
  private String areaValue;

  @ApiModelProperty(value = "是否可用")
  private String state;

  @ApiModelProperty(value = "管理人员联系方式")
  private String adminTel;

  @ApiModelProperty(value = "管理人员姓名")
  private String adminName;

  @ApiModelProperty(value = "备注")
  private String remarks;

  @ApiModelProperty(value = "父级ID")
  private String pid;

}
