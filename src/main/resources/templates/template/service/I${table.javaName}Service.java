package ${servicePath};

import ${dtoPath}.${table.javaName}DTO;
import ${voPath}.${table.javaName}VO;
import ${dtoPath}.${table.javaName}QueryDTO;
import java.util.List;
import com.github.pagehelper.PageInfo;

/**
 * @author ${author}
 * @date ${date}
 * @desc ${table.comment}Service
 */
 
public interface I${table.javaName}Service {

  /**
   * 新增
   *
   * @param ${table.javaNameLow}
   * @return
   */
  void save(${table.javaName}DTO ${table.javaNameLow});
  
  /**
   * 批量新增
   *
   * @param list
   * @return
   */
  void batchSave(List<${table.javaName}DTO> list);
  
  /**
   * 删除
   *
   * @param id
   */
  void deleteById(String id);
  
  /**
   * 修改
   *
   * @param ${table.javaNameLow}
   * @return
   */
  void update(${table.javaName}DTO ${table.javaNameLow});

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  ${table.javaName}VO findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  PageInfo<${table.javaName}VO> findAll(${table.javaName}QueryDTO query);
}
