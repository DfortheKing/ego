package com.ego.item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ego.item.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface BrandMapper extends BaseMapper<Brand> {
  @Insert("insert into tb_category_brand values(#{aLong},#{id})")
  void inserToCategoryBrand(Long aLong, Long id);

  @Delete("delete from tb_category_brand where brand_id=#{id}")
  void deleteBrandById(Long id);

}
