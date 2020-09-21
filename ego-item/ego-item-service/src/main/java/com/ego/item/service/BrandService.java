package com.ego.item.service;

import com.ego.common.pojo.Results;
import com.ego.item.pojo.Brand;

public interface BrandService {
  Results<Brand> page(Long pageNo, Long pageSize, String sortBy, Boolean descending, String key);

  //新增品牌
  void addBrand(Brand brand, Long[] cids);

  //删除品牌
  void deleteBrand(Long id);

  //修改品牌
  void updateBrand(Brand brand, Long[] cids);
}
