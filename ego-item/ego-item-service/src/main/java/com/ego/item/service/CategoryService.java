package com.ego.item.service;

import com.ego.item.pojo.Category;

import java.util.List;

public interface CategoryService {
  //根据pid查询商品列表
  List<Category> queryCategoryListByParentId(Long pid);

  //添加商品分类
  void addCategory(Category category);

//  更新节点
  void updateCategory(Long id, String name);

  //删除一个商品分类
  void deleteCategory(Long id);
}
