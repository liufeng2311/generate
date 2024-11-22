package com.generate.demo.domain.dto;

import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author liu
 * @date 2024-11-22
 * @desc DTO
 */

@Data
@ApiModel(description = "DTO")
public class UserDTO implements Serializable {

  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(value = "username")
  private String username;

  @ApiModelProperty(value = "password")
  private String password;

  @ApiModelProperty(value = "nickname")
  private String nickname;

}
