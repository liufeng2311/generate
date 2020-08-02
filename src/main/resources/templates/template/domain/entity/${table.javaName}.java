package ${entityPath};

import lombok.Data;
<#if table.dateFlag==true>
import java.util.Date;
</#if>
<#if table.localDateFlag==true>
import java.time.LocalDate;
</#if>
import java.io.Serializable;

/**
 * @author ${author}
 * @date ${date}
 * @desc ${table.comment}
 */

@Data
public class ${table.javaName} implements Serializable {
<#list table.columns as column>

  /**
   * ${column.columnComment}
   */
  private ${column.javaColumnType} ${column.javaColumnName};
</#list>

}
