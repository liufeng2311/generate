package com.generate.demo.service.impl;

import com.generate.demo.domain.dto.ThirdWorkSchemaDTO;
import com.generate.demo.domain.vo.ThirdWorkSchemaVO;
import com.generate.demo.domain.dto.ThirdWorkSchemaQueryDTO;
import com.generate.demo.domain.entity.ThirdWorkSchema;
import com.generate.demo.service.IThirdWorkSchemaService;
import com.generate.demo.mapper.ThirdWorkSchemaMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

/**
 * @author liuF
 * @date 2020-08-01
 * @desc 工作范围DTO
 */
 
@Service
public class ThirdWorkSchemaServiceImpl implements IThirdWorkSchemaService {

  @Autowired
  private ThirdWorkSchemaMapper thirdWorkSchemaMapper;

  @Override
  public void save(ThirdWorkSchemaDTO thirdWorkSchema) {
	  ThirdWorkSchema entity = new ThirdWorkSchema();
	  BeanUtils.copyProperties(thirdWorkSchema, entity);
	  thirdWorkSchemaMapper.save(entity);
  }
  
  @Override
  public void batchSave(List<ThirdWorkSchemaDTO> list) {
	  List<ThirdWorkSchema> entityList = new ArrayList();
	  list.forEach(x -> {
      ThirdWorkSchema entity = new ThirdWorkSchema();
	    BeanUtils.copyProperties(x, entity);
	    entityList.add(entity);
    });
	  thirdWorkSchemaMapper.batchSave(entityList);
  }
  
  @Override
  public void deleteById(String id) {
	  thirdWorkSchemaMapper.deleteById(id);
  }
  
  @Override
  public void update(ThirdWorkSchemaDTO thirdWorkSchema) {
	  ThirdWorkSchema entity = new ThirdWorkSchema();
	  BeanUtils.copyProperties(thirdWorkSchema, entity);
	  thirdWorkSchemaMapper.update(entity);
  }

  @Override
  public ThirdWorkSchemaVO findById(String id) {
	  ThirdWorkSchemaVO vo = new ThirdWorkSchemaVO();
	  ThirdWorkSchema entity = thirdWorkSchemaMapper.findById(id);
	  BeanUtils.copyProperties(entity, vo);
	  return vo;
  }
  
  @Override
  public PageInfo<ThirdWorkSchemaVO> findAll(ThirdWorkSchemaQueryDTO query) {
	  List<ThirdWorkSchemaVO> voList = new ArrayList<>();
	  Page<Object> page = PageHelper.startPage(query.getOffset(), query.getLimit());
	  List<ThirdWorkSchema> list = thirdWorkSchemaMapper.findAll(query);
	  list.forEach(x -> {
      ThirdWorkSchemaVO vo = new ThirdWorkSchemaVO();
      BeanUtils.copyProperties(x, vo);
      voList.add(vo);
    });
	  PageInfo info = new PageInfo(page.getResult());
    info.setList(voList);
	  return info;
  }
}
