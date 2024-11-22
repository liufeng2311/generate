package com.generate.demo.service.impl;

import com.generate.demo.domain.dto.UserDTO;
import com.generate.demo.service.base.BaseService;
import com.generate.demo.domain.vo.UserVO;
import com.generate.demo.domain.dto.UserQueryDTO;
import com.generate.demo.domain.entity.User;
import com.generate.demo.service.IUserService;
import com.generate.demo.mapper.UserMapper;
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
 * @date 2024-11-22
 * @desc DTO
 */
 
@Service
public class UserServiceImpl  extends BaseService implements IUserService{

  @Autowired
  private UserMapper userMapper;

  @Override
  public void save(UserDTO user) {
	  User entity = new User();
	  BeanUtils.copyProperties(user, entity);
	  userMapper.save(entity);
  }
  
  @Override
  public void batchSave(List<UserDTO> list) {
	  List<User> entityList = new ArrayList();
	  list.forEach(x -> {
      User entity = new User();
	    BeanUtils.copyProperties(x, entity);
	    entityList.add(entity);
    });
	  userMapper.batchSave(entityList);
  }
  
  @Override
  public void deleteById(String id) {
	  userMapper.deleteById(id);
  }
  
  @Override
  public void update(UserDTO user) {
	  User entity = new User();
	  BeanUtils.copyProperties(user, entity);
	  userMapper.update(entity);
  }

  @Override
  public UserVO findById(String id) {
	  UserVO vo = new UserVO();
	  User entity = userMapper.findById(id);
	  if (entity != null) {
      BeanUtils.copyProperties(entity, vo);
    }
	  return vo;
  }
  
  @Override
  public PageInfo<UserVO> findAll(UserQueryDTO query) {
	  List<UserVO> voList = new ArrayList<>();
	  Page<Object> page = PageHelper.startPage(query.getOffset(), query.getLimit());
	  List<User> list = userMapper.findAll(query);
	  list.forEach(x -> {
      UserVO vo = new UserVO();
      BeanUtils.copyProperties(x, vo);
      voList.add(vo);
    });
	  PageInfo info = new PageInfo(page);
    info.setList(voList);
	  return info;
  }
}
