package ${mapperPath};

import ${entityPath}.${table.javaName};
import ${dtoPath}.${table.javaName}QueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ${author}
 * @date ${date}
 * @desc ${table.comment}DTO
 */
 
@Mapper
public interface ${table.javaName}Mapper {

  /**
   * 新增
   *
   * @param  ${table.javaNameLow}
   * @return
   */
  boolean save(${table.javaName} ${table.javaNameLow});
  
  /**
   * 批量新增
   *
   * @param  list
   * @return
   */
  boolean batchSave(List<${table.javaName}> list);
  
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
  boolean update(${table.javaName} ${table.javaNameLow});

  /**
   * 根据ID查询单个
   *
   * @param id
   * @return
   */
  ${table.javaName} findById(String id);

  /**
   * 根据条件查询列表
   *
   * @param query
   * @return 
   */
  List<${table.javaName}> findAll(${table.javaName}QueryDTO query);

}
