package com.generate.demo.controller;

import com.generate.demo.result.PageInfo;
import com.generate.demo.service.IUserService;
import com.generate.demo.domain.dto.UserDTO;
import com.generate.demo.domain.vo.UserVO;
import com.generate.demo.domain.dto.UserQueryDTO;
import com.generate.demo.result.ResultModel;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu
 * @date 2024-11-22
 * @desc Controller
 */
 
@RestController
@RequestMapping(value = "/user")
@Api(tags = "")
public class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping(value = "/save")
  @ApiOperation(value = "新增")
  public ResultModel save(@RequestBody UserDTO save) {
    userService.save(save);
    return ResultModel.success();
  }

  @PostMapping(value = "/batchSave")
  @ApiOperation(value = "批量新增")
  public ResultModel save(@RequestBody List<UserDTO> save) {
    userService.batchSave(save);
    return ResultModel.success();
  }

  @GetMapping(value = "delete/{id}")
  @ApiOperation(value = "删除")
  public ResultModel update(@PathVariable(value = "id") String id) {
    userService.deleteById(id);
    return ResultModel.success();
  }

  @GetMapping(value = "find/{id}")
  @ApiOperation(value = "查询")
  public ResultModel findById(@PathVariable(value = "id") String id) {
    UserVO vo = userService.findById(id);
    return ResultModel.success(vo);
  }

  @PostMapping(value = "update")
  @ApiOperation(value = "更新")
  public ResultModel findById(@RequestBody UserDTO save) {
    userService.update(save);
    return ResultModel.success();
  }

  @PostMapping(value = "/findAll")
  @ApiOperation(value = "查询全部")
  public ResultModel findAll(@RequestBody UserQueryDTO query) {
    PageInfo<UserVO> info = userService.findAll(query);
    return ResultModel.success(info);
  }
}
