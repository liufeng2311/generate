package com.generate.demo.service.impl;

import com.generate.demo.domain.dto.ApproveReceiveDeptDTO;
import com.generate.demo.domain.vo.ApproveReceiveDeptVO;
import com.generate.demo.domain.dto.ApproveReceiveDeptQueryDTO;
import com.generate.demo.domain.entity.ApproveReceiveDept;
import com.generate.demo.service.IApproveReceiveDeptService;
import com.generate.demo.mapper.ApproveReceiveDeptMapper;
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
public class ApproveReceiveDeptServiceImpl implements IApproveReceiveDeptService {

  @Autowired
  private ApproveReceiveDeptMapper approveReceiveDeptMapper;

  @Override
  public void save(ApproveReceiveDeptDTO approveReceiveDept) {
	  ApproveReceiveDept entity = new ApproveReceiveDept();
	  BeanUtils.copyProperties(approveReceiveDept, entity);
	  approveReceiveDeptMapper.save(entity);
  }
  
  @Override
  public void batchSave(List<ApproveReceiveDeptDTO> list) {
	  List<ApproveReceiveDept> entityList = new ArrayList();
	  list.forEach(x -> {
      ApproveReceiveDept entity = new ApproveReceiveDept();
	    BeanUtils.copyProperties(x, entity);
	    entityList.add(entity);
    });
	  approveReceiveDeptMapper.batchSave(entityList);
  }
  
  @Override
  public void deleteById(String id) {
	  approveReceiveDeptMapper.deleteById(id);
  }
  
  @Override
  public void update(ApproveReceiveDeptDTO approveReceiveDept) {
	  ApproveReceiveDept entity = new ApproveReceiveDept();
	  BeanUtils.copyProperties(approveReceiveDept, entity);
	  approveReceiveDeptMapper.update(entity);
  }

  @Override
  public ApproveReceiveDeptVO findById(String id) {
	  ApproveReceiveDeptVO vo = new ApproveReceiveDeptVO();
	  ApproveReceiveDept entity = approveReceiveDeptMapper.findById(id);
	  if (entity != null) {
      BeanUtils.copyProperties(entity, vo);
    }
	  return vo;
  }
  
  @Override
  public PageInfo<ApproveReceiveDeptVO> findAll(ApproveReceiveDeptQueryDTO query) {
	  List<ApproveReceiveDeptVO> voList = new ArrayList<>();
	  Page<Object> page = PageHelper.startPage(query.getOffset(), query.getLimit());
	  List<ApproveReceiveDept> list = approveReceiveDeptMapper.findAll(query);
	  list.forEach(x -> {
      ApproveReceiveDeptVO vo = new ApproveReceiveDeptVO();
      BeanUtils.copyProperties(x, vo);
      voList.add(vo);
    });
	  PageInfo info = new PageInfo(page);
    info.setList(voList);
	  return info;
  }
}
