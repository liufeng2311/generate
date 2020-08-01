package com.mapper;

import com.domain.entity.ThirdWorkSchema;
import com.domain.dto.ThirdWorkSchemaQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuF
 * @date 2020-08-01
 * @desc 工作范围DTO
 */
 
@Mapper
public interface ThirdWorkSchemaMapper {

  /**
   * 新增
   *
   * @param  thirdWorkSchema
   * @return
   */
  boolean save(ThirdWorkSchema thirdWorkSchema);
  
  /**
   * 批量新增
   *
   * @param  list
   * @return
   */
  boolean batchSave(List<ThirdWorkSchema> list);
  
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
  boolean update(ThirdWorkSchema thirdWorkSchema);

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  ThirdWorkSchema findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  List<ThirdWorkSchema> findAll(ThirdWorkSchemaQueryDTO query);

}
