package com.flint.tcc.order.entity.mysql;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * Created by ligeng on 17/9/30.
 */
@Data
@MappedSuperclass
public class DrugBaseEntity extends BaseEntity{
    @ApiModelProperty("创建人")
    private Long createUser;

    @ApiModelProperty("更新人")
    private Long updateUser;

    @ApiModelProperty("状态 1:删除 0：正常")
    private int status =0;
}
