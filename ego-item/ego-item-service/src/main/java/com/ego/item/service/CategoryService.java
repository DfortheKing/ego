package com.ego.item.service;

import com.ego.item.pojo.Category;

import java.util.List;

public interface CategoryService {
  //通过parentId查询所有的商品
  List<Category> findCategoryByPid(Long pid);

  //新增商品分类
  void addCategory(Category category);

  //修改一个商品分类
  void updateCategory(Long id, String name);

  //删除一个商品分类
  void deleteCategory(Long id);
}
