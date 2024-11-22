package com.generate.demo.domain.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * @author liu
 * @date 2024-11-22
 * @desc 
 */

@Data
public class User implements Serializable {

  /**
   * id
   */
  private Integer id;

  /**
   * username
   */
  private String username;

  /**
   * password
   */
  private String password;

  /**
   * nickname
   */
  private String nickname;

}
