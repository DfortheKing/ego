package com.ego.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ego.common.pojo.Results;
import com.ego.item.mapper.BrandMapper;
import com.ego.item.pojo.Brand;
import com.ego.item.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BrandServiceImpl implements BrandService {
  @Resource
  private BrandMapper brandMapper;

  @Override
  public Results<Brand> page(Long pageNo, Long pageSize, String sortBy, Boolean descending, String key) {

    QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
    //判断过滤条件是否存在
    if(!StringUtils.isBlank(key)){
      queryWrapper.like("name",key).or().eq("letter",key.toUpperCase());
    }

    //判断排序条件是否存在
    if(StringUtils.isNoneEmpty(sortBy)&&!descending){
      queryWrapper.orderBy(true,!descending,sortBy);
    }
    //如果查询条件存在
    Page<Brand> brandPage = brandMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);
    Results<Brand> brandResults = new Results<>(brandPage.getRecords(), brandPage.getTotal());
    return brandResults;
  }

  //新增品牌
  @Override
  public void addBrand(Brand brand, Long[] cids) {
    brandMapper.insert(brand);
    for (Long aLong : cids) {
      brandMapper.inserToCategoryBrand(aLong, brand.getId());
    }
  }

  //删除品牌
  @Override
  public void deleteBrand(Long id) {
    brandMapper.deleteBrandById(id);
    brandMapper.deleteById(id);
  }

  //更新品牌
  @Override
  public void updateBrand(Brand brand, Long[] cids) {
    Long id = brand.getId();
    brandMapper.deleteBrandById(id);//删除中间表

    brandMapper.updateById(brand);//更新brand数据
    for (Long cid : cids) {
      brandMapper.inserToCategoryBrand(cid,id);//插入中间表
    }
  }
}
