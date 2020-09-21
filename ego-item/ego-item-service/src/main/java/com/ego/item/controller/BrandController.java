package com.ego.item.controller;

import com.ego.common.pojo.Results;
import com.ego.item.pojo.Brand;
import com.ego.item.service.BrandService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/brand")
public class BrandController {

  @Resource
  private BrandService brandService;
  /**
   * 分页显示品牌信息
   */
//  http://api.ego.com/api/item/brand/page?pageNo=1&pageSize=5&sortBy=name&descending=false&key=
  @GetMapping("/page")
  public ResponseEntity<Results<Brand>> page(
    @RequestParam("pageNo") Long pageNo,
    @RequestParam("pageSize") Long pageSize,
    @RequestParam(value = "sortBy",required = false) String sortBy,
    @RequestParam(value = "descending",required = false) Boolean descending,
    @RequestParam("key") String key
  ){
    //查询数据库中的数据,并封装成前端期望的类型
    Results<Brand> brandResults = brandService.page(pageNo,pageSize,sortBy,descending,key);
    //判断查询出来的数据是否有值
    if(CollectionUtils.isEmpty(brandResults.getItems())){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(brandResults);
  }

  //增加品牌分类
  @PostMapping
  public ResponseEntity<Void> addBrand( Brand brand, @RequestParam("cids") Long[] cids){
    brandService.addBrand(brand,cids);
    return ResponseEntity.ok().build();
  }

  //删除品牌
  @DeleteMapping
  public ResponseEntity<Void> deleteBrand(@RequestParam("id") Long id){
    brandService.deleteBrand(id);
    return ResponseEntity.ok().build();
  }

//  更新品牌
  @PutMapping
  public ResponseEntity<Void> updateBrand(Brand brand, @RequestParam("cids") Long[] cids){
    brandService.updateBrand(brand,cids);
    return ResponseEntity.ok().build();
  }
}

