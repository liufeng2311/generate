package com.generate.demo.service;

import com.generate.demo.domain.dto.ThirdWorkSchemaDTO;
import com.generate.demo.domain.vo.ThirdWorkSchemaVO;
import com.generate.demo.domain.dto.ThirdWorkSchemaQueryDTO;
import java.util.List;
import com.github.pagehelper.PageInfo;

/**
 * @author liuF
 * @date 2020-08-01
 * @desc 工作范围Service
 */
 
public interface IThirdWorkSchemaService {

  /**
   * 新增
   *
   * @param thirdWorkSchema
   * @return
   */
  void save(ThirdWorkSchemaDTO thirdWorkSchema);
  
  /**
   * 批量新增
   *
   * @param list
   * @return
   */
  void batchSave(List<ThirdWorkSchemaDTO> list);
  
  /**
   * 删除
   *
   * @param id
   */
  void deleteById(String id);
  
  /**
   * 修改
   *
   * @param thirdWorkSchema
   * @return
   */
  void update(ThirdWorkSchemaDTO thirdWorkSchema);

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  ThirdWorkSchemaVO findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  PageInfo<ThirdWorkSchemaVO> findAll(ThirdWorkSchemaQueryDTO query);
}
