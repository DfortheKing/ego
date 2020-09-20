package com.ego.item.controller;

import com.ego.common.pojo.PageResult;
import com.ego.item.pojo.Brand;
import com.ego.item.service.BrandService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


// http://api.ego.com/api/item/brand/page?pageNo=1&pageSize=5&sortBy=name&descending=false&key= 404
@RestController
@RequestMapping("/brand")
public class BrandController {

  @Resource
  private BrandService brandService;

  @RequestMapping("/page")
  public ResponseEntity<PageResult<Brand>> page(
    @RequestParam("pageNo") Long pageNo,
    @RequestParam("pageSize") Long pageSize,
    @RequestParam(value = "sortBy",required = false) String sortBy,
    @RequestParam(value = "descending",required = false) Boolean descending,
    @RequestParam("key") String key
  ){

    //查询数据库
    PageResult<Brand> result = brandService.page(pageNo,pageSize,sortBy,descending,key);
    if(result!=null&& CollectionUtils.isNotEmpty(result.getItems())){
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.noContent().build();
  }
}
