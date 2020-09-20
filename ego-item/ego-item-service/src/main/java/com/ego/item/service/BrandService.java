package com.ego.item.service;

import com.ego.common.pojo.PageResult;
import com.ego.item.pojo.Brand;

public interface BrandService {
  PageResult<Brand> page(Long pageNo, Long pageSize, String sortBy, Boolean descending,String key);
}
