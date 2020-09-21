package com.ego.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_brand")
public class Brand {
  @TableId(type = IdType.AUTO)
  private Long id;
  private String name;
  private String image;
  private String letter;
}
