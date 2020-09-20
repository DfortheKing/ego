package com.ego.common.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

  private Long total;
  private Long totalPage;
  private List<T> items;

  public PageResult(Long total, List<T> items) {
    this.total = total;
    this.items = items;
  }

  public PageResult(Long total, Long totalPage, List<T> items) {
    this.total = total;
    this.totalPage = totalPage;
    this.items = items;
  }

  public PageResult(List<T> items) {
    this.items = items;
  }
}
