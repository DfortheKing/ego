package com.ego.common.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Results<T>{
  private List<T> items;
  private Long total;
  private Long page;

  public Results() {
  }

  public Results(List<T> items, Long total) {
    this.items = items;
    this.total = total;
  }

  public Results(List<T> items, Long total, Long page) {
    this.items = items;
    this.total = total;
    this.page = page;
  }
}
