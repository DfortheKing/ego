package com.ego.item.controller;

import com.ego.item.pojo.Category;
import com.ego.item.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
  @Resource(name = "categoryService")
  private CategoryService categoryService;

  @RequestMapping("/list")
  public ResponseEntity<List<Category>> queryCategoryListByParentId(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
    try {
      if (pid == null || pid.longValue() < 0) {
        return ResponseEntity.badRequest().build();
      }
      List<Category> categoryList = categoryService.queryCategoryListByParentId(pid);
      if (CollectionUtils.isEmpty(categoryList)) {
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(categoryList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.notFound().build();
  }
}
