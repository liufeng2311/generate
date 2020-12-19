package com.generate.demo.mapper;

import com.generate.demo.domain.entity.ApproveReceiveDept;
import com.generate.demo.domain.dto.ApproveReceiveDeptQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liu
 * @date 2020-08-04
 * @desc DTO
 */
 
@Mapper
public interface ApproveReceiveDeptMapper {

  /**
   * 新增
   *
   * @param  approveReceiveDept
   * @return
   */
  boolean save(ApproveReceiveDept approveReceiveDept);
  
  /**
   * 批量新增
   *
   * @param  list
   * @return
   */
  boolean batchSave(List<ApproveReceiveDept> list);
  
   /**
   * 删除
   *
   * @param id
   */
  void deleteById(String id);
  
    /**
   * 修改
   *
   * @param approveReceiveDept
   * @return
   */
  boolean update(ApproveReceiveDept approveReceiveDept);

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  ApproveReceiveDept findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  List<ApproveReceiveDept> findAll(ApproveReceiveDeptQueryDTO query);

}
