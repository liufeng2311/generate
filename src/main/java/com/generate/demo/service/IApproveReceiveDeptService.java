package com.generate.demo.service;

import com.generate.demo.domain.dto.ApproveReceiveDeptDTO;
import com.generate.demo.domain.vo.ApproveReceiveDeptVO;
import com.generate.demo.domain.dto.ApproveReceiveDeptQueryDTO;
import java.util.List;
import com.generate.demo.result.PageInfo;

/**
 * @author liu
 * @date 2020-08-04
 * @desc Service
 */
 
public interface IApproveReceiveDeptService {

  /**
   * 新增
   *
   * @param approveReceiveDept
   * @return
   */
  void save(ApproveReceiveDeptDTO approveReceiveDept);
  
  /**
   * 批量新增
   *
   * @param list
   * @return
   */
  void batchSave(List<ApproveReceiveDeptDTO> list);
  
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
  void update(ApproveReceiveDeptDTO approveReceiveDept);

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  ApproveReceiveDeptVO findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  PageInfo<ApproveReceiveDeptVO> findAll(ApproveReceiveDeptQueryDTO query);
}
