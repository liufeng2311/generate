package ${controllerPath};

import com.github.pagehelper.PageInfo;
import ${servicePath}.I${table.javaName}Service;
import ${dtoPath}.${table.javaName}DTO;
import ${voPath}.${table.javaName}VO;
import ${dtoPath}.${table.javaName}QueryDTO;
import ${resultPath}.ResultModel;
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
 * @author ${author}
 * @date ${date}
 * @desc ${table.comment}Controller
 */
 
@RestController
@RequestMapping(value = "/${table.javaNameLow}")
@Api(tags = "${table.comment}")
public class ${table.javaName}Controller {

  @Autowired
  private I${table.javaName}Service ${table.javaNameLow}Service;

  @PostMapping(value = "/save")
  @ApiOperation(value = "新增")
  public ResultModel save(@RequestBody ${table.javaName}DTO save) {
    ${table.javaNameLow}Service.save(save);
    return ResultModel.success();
  }
  
  @PostMapping(value = "/batchSave")
  @ApiOperation(value = "批量新增")
  public ResultModel save(@RequestBody List<${table.javaName}DTO> save) {
    ${table.javaNameLow}Service.batchSave(save);
    return ResultModel.success();
  }

  @GetMapping(value = "delete/{id}")
  @ApiOperation(value = "删除")
  public ResultModel update(@PathVariable(value = "id") String id) {
    ${table.javaNameLow}Service.deleteById(id);
    return ResultModel.success();
  }

  @GetMapping(value = "find/{id}")
  @ApiOperation(value = "查询")
  public ResultModel findById(@PathVariable(value = "id") String id) {
    ${table.javaName}VO vo = ${table.javaNameLow}Service.findById(id);
    return ResultModel.success(vo);
  }
	
  @PostMapping(value = "update")
  @ApiOperation(value = "更新")
  public ResultModel findById(@RequestBody ${table.javaName}DTO save) {
    ${table.javaNameLow}Service.update(save);
    return ResultModel.success();
  }


  @PostMapping(value = "/findAll")
  @ApiOperation(value = "查询全部")
  public ResultModel findAll(@RequestBody ${table.javaName}QueryDTO query) {
    PageInfo<${table.javaName}VO> info = ${table.javaNameLow}Service.findAll(query);
    return ResultModel.success(info);
  }

}
