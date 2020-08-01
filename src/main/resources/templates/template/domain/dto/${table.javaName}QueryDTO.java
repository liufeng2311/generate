package ${dtoPath};

<#if dateFlag=="true">
import java.util.Date;
</#if>
<#if localDateFlag=="true">
import java.time.LocalDate;
</#if>
<#if jsonFormatFlag=="true">
import com.fasterxml.jackson.annotation.JsonFormat;
</#if>
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ${author}
 * @date ${date}
 * @desc ${table.comment}QueryDTO
 */

@Data
@ApiModel(description = "${table.comment}QueryDTO")
public class ${table.javaName}QueryDTO {
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

  @ApiModelProperty(value = "页码")
  private Integer offset;
  
  @ApiModelProperty(value = "条数")
  private Integer limit;

}
