package com.ego.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ego.item.mapper.CategoryMapper;
import com.ego.item.pojo.Category;
import com.ego.item.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("categoryService")
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
}
