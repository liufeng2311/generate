package com.generate.demo.service;

import com.generate.demo.domain.dto.UserDTO;
import com.generate.demo.domain.vo.UserVO;
import com.generate.demo.domain.dto.UserQueryDTO;
import java.util.List;
import com.generate.demo.result.PageInfo;

/**
 * @author liu
 * @date 2024-11-22
 * @desc Service
 */
 
public interface IUserService {

  /**
   * 新增
   *
   * @param user
   * @return
   */
  void save(UserDTO user);
  
  /**
   * 批量新增
   *
   * @param list
   * @return
   */
  void batchSave(List<UserDTO> list);
  
  /**
   * 删除
   *
   * @param id
   */
  void deleteById(String id);
  
  /**
   * 修改
   *
   * @param user
   * @return
   */
  void update(UserDTO user);

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  UserVO findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  PageInfo<UserVO> findAll(UserQueryDTO query);
}
