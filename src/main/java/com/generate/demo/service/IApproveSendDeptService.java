package com.generate.demo.service;

import com.generate.demo.domain.dto.ApproveSendDeptDTO;
import com.generate.demo.domain.vo.ApproveSendDeptVO;
import com.generate.demo.domain.dto.ApproveSendDeptQueryDTO;
import java.util.List;
import com.generate.demo.result.PageInfo;

/**
 * @author liu
 * @date 2020-08-04
 * @desc Service
 */
 
public interface IApproveSendDeptService {

  /**
   * 新增
   *
   * @param approveSendDept
   * @return
   */
  void save(ApproveSendDeptDTO approveSendDept);
  
  /**
   * 批量新增
   *
   * @param list
   * @return
   */
  void batchSave(List<ApproveSendDeptDTO> list);
  
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
  void update(ApproveSendDeptDTO approveSendDept);

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  ApproveSendDeptVO findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  PageInfo<ApproveSendDeptVO> findAll(ApproveSendDeptQueryDTO query);
}
