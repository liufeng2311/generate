package com.generate.demo.domain.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author liuF
 * @date 2020-08-01
 * @desc 工作范围QueryDTO
 */

@Data
@ApiModel(description = "工作范围QueryDTO")
public class ThirdWorkSchemaQueryDTO {

  @ApiModelProperty(value = "id")
  private String id;

  @ApiModelProperty(value = "第三方ID")
  private String thirdId;

  @ApiModelProperty(value = "第三方名称")
  private String thirdName;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "开放查询开始时间", example = "2020-08-01")
  private LocalDate beginDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "放开查询结束时间", example = "2020-08-01")
  private LocalDate endDate;

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

  @ApiModelProperty(value = "页码")
  private Integer offset;
  
  @ApiModelProperty(value = "条数")
  private Integer limit;

}
