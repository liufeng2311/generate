package com.controller;

import com.github.pagehelper.PageInfo;
import com.service.IThirdWorkSchemaService;
import com.domain.dto.ThirdWorkSchemaDTO;
import com.domain.vo.ThirdWorkSchemaVO;
import com.domain.dto.ThirdWorkSchemaQueryDTO;
import com.result.ResultModel;
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
 * @author liuF
 * @date 2020-08-01
 * @desc 工作范围Controller
 */
 
@RestController
@RequestMapping(value = "/thirdWorkSchema")
@Api(tags = "工作范围")
public class ThirdWorkSchemaController {

  @Autowired
  private IThirdWorkSchemaService thirdWorkSchemaService;

  @PostMapping(value = "/save")
  @ApiOperation(value = "新增")
  public ResultModel save(@RequestBody ThirdWorkSchemaDTO save) {
    thirdWorkSchemaService.save(save);
    return ResultModel.success();
  }
  
  @PostMapping(value = "/batchSave")
  @ApiOperation(value = "批量新增")
  public ResultModel save(@RequestBody List<ThirdWorkSchemaDTO> save) {
    thirdWorkSchemaService.batchSave(save);
    return ResultModel.success();
  }

  @GetMapping(value = "delete/{id}")
  @ApiOperation(value = "删除")
  public ResultModel update(@PathVariable(value = "id") String id) {
    thirdWorkSchemaService.deleteById(id);
    return ResultModel.success();
  }

  @GetMapping(value = "find/{id}")
  @ApiOperation(value = "查询")
  public ResultModel findById(@PathVariable(value = "id") String id) {
    ThirdWorkSchemaVO vo = thirdWorkSchemaService.findById(id);
    return ResultModel.success(vo);
  }
	
  @PostMapping(value = "update")
  @ApiOperation(value = "更新")
  public ResultModel findById(@RequestBody ThirdWorkSchemaDTO save) {
    thirdWorkSchemaService.update(save);
    return ResultModel.success();
  }


  @PostMapping(value = "/findAll")
  @ApiOperation(value = "查询全部")
  public ResultModel findAll(@RequestBody ThirdWorkSchemaQueryDTO query) {
    PageInfo<ThirdWorkSchemaVO> info = thirdWorkSchemaService.findAll(query);
    return ResultModel.success(info);
  }

}
