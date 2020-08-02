package ${serviceImplPath};

import ${dtoPath}.${table.javaName}DTO;
import ${voPath}.${table.javaName}VO;
import ${dtoPath}.${table.javaName}QueryDTO;
import ${entityPath}.${table.javaName};
import ${servicePath}.I${table.javaName}Service;
import ${mapperPath}.${table.javaName}Mapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

/**
 * @author ${author}
 * @date ${date}
 * @desc ${table.comment}DTO
 */
 
@Service
public class ${table.javaName}ServiceImpl implements I${table.javaName}Service {

  @Autowired
  private ${table.javaName}Mapper ${table.javaNameLow}Mapper;

  @Override
  public void save(${table.javaName}DTO ${table.javaNameLow}) {
	  ${table.javaName} entity = new ${table.javaName}();
	  BeanUtils.copyProperties(${table.javaNameLow}, entity);
	  ${table.javaNameLow}Mapper.save(entity);
  }
  
  @Override
  public void batchSave(List<${table.javaName}DTO> list) {
	  List<${table.javaName}> entityList = new ArrayList();
	  list.forEach(x -> {
      ${table.javaName} entity = new ${table.javaName}();
	    BeanUtils.copyProperties(x, entity);
	    entityList.add(entity);
    });
	  ${table.javaNameLow}Mapper.batchSave(entityList);
  }
  
  @Override
  public void deleteById(String id) {
	  ${table.javaNameLow}Mapper.deleteById(id);
  }
  
  @Override
  public void update(${table.javaName}DTO ${table.javaNameLow}) {
	  ${table.javaName} entity = new ${table.javaName}();
	  BeanUtils.copyProperties(${table.javaNameLow}, entity);
	  ${table.javaNameLow}Mapper.update(entity);
  }

  @Override
  public ${table.javaName}VO findById(String id) {
	  ${table.javaName}VO vo = new ${table.javaName}VO();
	  ${table.javaName} entity = ${table.javaNameLow}Mapper.findById(id);
	  if (entity != null) {
      BeanUtils.copyProperties(entity, vo);
    }
	  return vo;
  }
  
  @Override
  public PageInfo<${table.javaName}VO> findAll(${table.javaName}QueryDTO query) {
	  List<${table.javaName}VO> voList = new ArrayList<>();
	  Page<Object> page = PageHelper.startPage(query.getOffset(), query.getLimit());
	  List<${table.javaName}> list = ${table.javaNameLow}Mapper.findAll(query);
	  list.forEach(x -> {
      ${table.javaName}VO vo = new ${table.javaName}VO();
      BeanUtils.copyProperties(x, vo);
      voList.add(vo);
    });
	  PageInfo info = new PageInfo(page.getResult());
    info.setList(voList);
	  return info;
  }
}
