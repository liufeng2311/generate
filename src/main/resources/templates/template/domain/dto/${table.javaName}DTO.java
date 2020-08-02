package ${dtoPath};

import lombok.Data;
import java.io.Serializable;
<#if table.dateFlag==true>
import java.util.Date;
</#if>
<#if table.localDateFlag==true>
import java.time.LocalDate;
</#if>
<#if table.jsonFormatFlag==true>
import com.fasterxml.jackson.annotation.JsonFormat;
</#if>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ${author}
 * @date ${date}
 * @desc ${table.comment}DTO
 */

@Data
@ApiModel(description = "${table.comment}DTO")
public class ${table.javaName}DTO implements Serializable {
<#list table.columns as column>

  <#if column.date==true>
  @JsonFormat(pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "${column.columnComment}", example = "2020-08-01")
  </#if>
  <#if column.date==false>
  @ApiModelProperty(value = "${column.columnComment}")
  </#if>
  private ${column.javaColumnType} ${column.javaColumnName};
</#list>

}
