package com.generate.demo.result;

import java.util.List;
import com.github.pagehelper.Page;
import lombok.Data;

@Data
public class PageInfo<T> {

  //总数
  private Long totalNum;

  //总页数
  private Long totalPageNum;

  //数据
  private List<T> list;

  //查询页
  private Integer pageNum;

  //查询数量
  private Integer pageSize;

  //是否为第一页
  private boolean isFirstPage;

  //是否为最后一页
  private boolean isLastPage;

  //是否存在前一页
  private boolean hasPreviousPage;

  //是否存在后一页
  private boolean hasNextPage;

  public PageInfo(Page<T> page) {
    this.totalNum = page.getTotal();
    this.list = page.getResult();
    this.pageNum = page.getPageNum();
    this.pageSize = page.getPageSize();
    this.totalPageNum = totalNum % pageSize == 0 ? totalNum % pageSize : totalNum % pageSize + 1;
    this.isFirstPage = pageNum == 1 ? true : false;
    this.isLastPage = Long.valueOf(pageNum) == totalPageNum ? true : false;
    this.hasPreviousPage = pageNum == 1 ? false : true;
    this.hasNextPage = Long.valueOf(pageNum) == totalPageNum ? false : true;
  }
}
