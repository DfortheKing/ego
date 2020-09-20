package com.ego.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ego.common.pojo.PageResult;
import com.ego.item.mapper.BrandMapper;
import com.ego.item.pojo.Brand;
import com.ego.item.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BrandServiceImpl implements BrandService {
  @Resource
  private BrandMapper brandMapper;
  @Override
  public PageResult<Brand> page(Long pageNo, Long pageSize, String sortBy, Boolean descending,String key) {

    QueryWrapper<Brand> queryWrapper = new QueryWrapper();
    if(StringUtils.isNoneEmpty(key)){
      queryWrapper.like("name",key)
        .or()
        .eq("letter",key.toUpperCase());
    }

    //排序条件
    if (StringUtils.isNotBlank(sortBy) && descending != null) {
      queryWrapper.orderBy(true,!descending,sortBy);
    }
    Page<Brand> brandPage = brandMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);
    return new PageResult<>(brandPage.getTotal(),brandPage.getRecords());
  }
}
