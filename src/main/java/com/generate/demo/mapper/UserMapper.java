package com.generate.demo.mapper;

import com.generate.demo.domain.entity.User;
import com.generate.demo.domain.dto.UserQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liu
 * @date 2024-11-22
 * @desc DTO
 */
 
@Mapper
public interface UserMapper {

  /**
   * 新增
   *
   * @param  user
   * @return
   */
  boolean save(User user);
  
  /**
   * 批量新增
   *
   * @param  list
   * @return
   */
  boolean batchSave(List<User> list);
  
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
  boolean update(User user);

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  User findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  List<User> findAll(UserQueryDTO query);

}
