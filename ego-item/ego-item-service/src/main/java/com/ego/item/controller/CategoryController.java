package com.ego.item.controller;

import com.ego.item.pojo.Brand;
import com.ego.item.pojo.Category;
import com.ego.item.service.CategoryService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {


  //注入Service
  @Resource
  private CategoryService categoryService;
  //查询商品分类集合
  @RequestMapping("/list")
  public ResponseEntity<List<Category>> queryCategoryByPid(@RequestParam(value = "pid",defaultValue = "0") Long pid){
    try {
      if(pid<0&&pid==null){
        return ResponseEntity.badRequest().build();
      }
      //查询商品
      List<Category> categoryList = categoryService.findCategoryByPid(pid);
      //判断查询出来的结果是否有数据
      if(CollectionUtils.isEmpty(categoryList)){
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(categoryList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.status(500).build();
  }

  /**
   * 新增一个节点
   */
  @PostMapping
  public ResponseEntity<Void> addCategory(@RequestBody Category category){
    try {
      categoryService.addCategory(category);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.status(500).build();
  }

  /**
   * 修改一个节点
   */
  @PutMapping
  public ResponseEntity<Void> updateCategory(@RequestParam(value = "id") Long id,@RequestParam(value = "name") String name){
    try {
      categoryService.updateCategory(id,name);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.status(500).build();
  }

  /**
   * 删除一个节点
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
    try {
      categoryService.deleteCategory(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.status(500).build();
  }

  //  更新品牌
  @GetMapping("/bid/{bid}")
  public ResponseEntity<Brand> selectByBid(@PathVariable Long bid){
    return null;
  }
}
