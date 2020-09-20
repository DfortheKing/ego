package com.ego.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ego.item.mapper.CategoryMapper;
import com.ego.item.pojo.Category;
import com.ego.item.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
  @Resource
  private CategoryMapper categoryMapper;

  @Override
  public List<Category> queryCategoryListByParentId(Long pid) {
    QueryWrapper queryWrapper = new QueryWrapper();
    queryWrapper.eq("parent_id",pid);
    List list = categoryMapper.selectList(queryWrapper);
    return list;
  }

  @Override
  public void addCategory(Category category) {
    categoryMapper.insert(category);
  }

  @Override
  public void updateCategory(Long id, String name) {
    Category category = categoryMapper.selectById(id);
    category.setName(name);
    categoryMapper.updateById(category);
  }

  @Override
  public void deleteCategory(Long id) {
    categoryMapper.deleteById(id);
  }
}
