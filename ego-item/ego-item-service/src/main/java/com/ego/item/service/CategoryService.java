package com.ego.item.service;

import com.ego.item.pojo.Category;

import java.util.List;

public interface CategoryService {
  //根据pid查询商品列表
  List<Category> queryCategoryListByParentId(Long pid);
}
