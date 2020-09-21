package com.ego.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_category")
public class Category {
  @TableId(type = IdType.AUTO)
  private Long id;

  private String name;

  @TableField("parent_id")
  private Long parentId;

  @TableField("is_parent")
  private Boolean isParent;

  private Integer sort;
}
