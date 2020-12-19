package com.generate.demo.service.impl;

import com.generate.demo.domain.dto.ApproveSendDeptDTO;
import com.generate.demo.domain.vo.ApproveSendDeptVO;
import com.generate.demo.domain.dto.ApproveSendDeptQueryDTO;
import com.generate.demo.domain.entity.ApproveSendDept;
import com.generate.demo.service.IApproveSendDeptService;
import com.generate.demo.mapper.ApproveSendDeptMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.generate.demo.result.PageInfo;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

/**
 * @author liu
 * @date 2020-08-04
 * @desc DTO
 */
 
@Service
public class ApproveSendDeptServiceImpl implements IApproveSendDeptService {

  @Autowired
  private ApproveSendDeptMapper approveSendDeptMapper;

  @Override
  public void save(ApproveSendDeptDTO approveSendDept) {
	  ApproveSendDept entity = new ApproveSendDept();
	  BeanUtils.copyProperties(approveSendDept, entity);
	  approveSendDeptMapper.save(entity);
  }
  
  @Override
  public void batchSave(List<ApproveSendDeptDTO> list) {
	  List<ApproveSendDept> entityList = new ArrayList();
	  list.forEach(x -> {
      ApproveSendDept entity = new ApproveSendDept();
	    BeanUtils.copyProperties(x, entity);
	    entityList.add(entity);
    });
	  approveSendDeptMapper.batchSave(entityList);
  }
  
  @Override
  public void deleteById(String id) {
	  approveSendDeptMapper.deleteById(id);
  }
  
  @Override
  public void update(ApproveSendDeptDTO approveSendDept) {
	  ApproveSendDept entity = new ApproveSendDept();
	  BeanUtils.copyProperties(approveSendDept, entity);
	  approveSendDeptMapper.update(entity);
  }

  @Override
  public ApproveSendDeptVO findById(String id) {
	  ApproveSendDeptVO vo = new ApproveSendDeptVO();
	  ApproveSendDept entity = approveSendDeptMapper.findById(id);
	  if (entity != null) {
      BeanUtils.copyProperties(entity, vo);
    }
	  return vo;
  }
  
  @Override
  public PageInfo<ApproveSendDeptVO> findAll(ApproveSendDeptQueryDTO query) {
	  List<ApproveSendDeptVO> voList = new ArrayList<>();
	  Page<Object> page = PageHelper.startPage(query.getOffset(), query.getLimit());
	  List<ApproveSendDept> list = approveSendDeptMapper.findAll(query);
	  list.forEach(x -> {
      ApproveSendDeptVO vo = new ApproveSendDeptVO();
      BeanUtils.copyProperties(x, vo);
      voList.add(vo);
    });
	  PageInfo info = new PageInfo(page);
    info.setList(voList);
	  return info;
  }
}
