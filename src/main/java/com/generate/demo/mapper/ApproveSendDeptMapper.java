package com.generate.demo.mapper;

import com.generate.demo.domain.entity.ApproveSendDept;
import com.generate.demo.domain.dto.ApproveSendDeptQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liu
 * @date 2020-08-04
 * @desc DTO
 */
 
@Mapper
public interface ApproveSendDeptMapper {

  /**
   * 新增
   *
   * @param  approveSendDept
   * @return
   */
  boolean save(ApproveSendDept approveSendDept);
  
  /**
   * 批量新增
   *
   * @param  list
   * @return
   */
  boolean batchSave(List<ApproveSendDept> list);
  
   /**
   * 删除
   *
   * @param id
   */
  void deleteById(String id);
  
    /**
   * 修改
   *
   * @param approveSendDept
   * @return
   */
  boolean update(ApproveSendDept approveSendDept);

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  ApproveSendDept findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  List<ApproveSendDept> findAll(ApproveSendDeptQueryDTO query);

}
