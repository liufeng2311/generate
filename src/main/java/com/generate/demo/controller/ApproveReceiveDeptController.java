package com.generate.demo.controller;

import com.generate.demo.result.PageInfo;
import com.generate.demo.service.IApproveReceiveDeptService;
import com.generate.demo.domain.dto.ApproveReceiveDeptDTO;
import com.generate.demo.domain.vo.ApproveReceiveDeptVO;
import com.generate.demo.domain.dto.ApproveReceiveDeptQueryDTO;
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
 * @date 2020-08-04
 * @desc Controller
 */
 
@RestController
@RequestMapping(value = "/approveReceiveDept")
@Api(tags = "")
public class ApproveReceiveDeptController {

  @Autowired
  private IApproveReceiveDeptService approveReceiveDeptService;

  @PostMapping(value = "/save")
  @ApiOperation(value = "新增")
  public ResultModel save(@RequestBody ApproveReceiveDeptDTO save) {
    approveReceiveDeptService.save(save);
    return ResultModel.success();
  }

  @PostMapping(value = "/batchSave")
  @ApiOperation(value = "批量新增")
  public ResultModel save(@RequestBody List<ApproveReceiveDeptDTO> save) {
    approveReceiveDeptService.batchSave(save);
    return ResultModel.success();
  }

  @GetMapping(value = "delete/{id}")
  @ApiOperation(value = "删除")
  public ResultModel update(@PathVariable(value = "id") String id) {
    approveReceiveDeptService.deleteById(id);
    return ResultModel.success();
  }

  @GetMapping(value = "find/{id}")
  @ApiOperation(value = "查询")
  public ResultModel findById(@PathVariable(value = "id") String id) {
    ApproveReceiveDeptVO vo = approveReceiveDeptService.findById(id);
    return ResultModel.success(vo);
  }

  @PostMapping(value = "update")
  @ApiOperation(value = "更新")
  public ResultModel findById(@RequestBody ApproveReceiveDeptDTO save) {
    approveReceiveDeptService.update(save);
    return ResultModel.success();
  }

  @PostMapping(value = "/findAll")
  @ApiOperation(value = "查询全部")
  public ResultModel findAll(@RequestBody ApproveReceiveDeptQueryDTO query) {
    PageInfo<ApproveReceiveDeptVO> info = approveReceiveDeptService.findAll(query);
    return ResultModel.success(info);
  }
}
