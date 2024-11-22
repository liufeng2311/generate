package com.generate.demo.domain.dto;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author liu
 * @date 2024-11-22
 * @desc QueryDTO
 */

@Data
@ApiModel(description = "QueryDTO")
public class UserQueryDTO {

  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(value = "username")
  private String username;

  @ApiModelProperty(value = "password")
  private String password;

  @ApiModelProperty(value = "nickname")
  private String nickname;

  @ApiModelProperty(value = "页码")
  private Integer offset;
  
  @ApiModelProperty(value = "条数")
  private Integer limit;

}
