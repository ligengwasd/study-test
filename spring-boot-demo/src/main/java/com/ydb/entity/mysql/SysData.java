package com.ydb.entity.mysql;

import com.ydb.enums.LevelEnum;
import com.ydb.enums.SysDataEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@ApiModel(description = "系统数据标签表")
@Entity
@Data
@NamedStoredProcedureQuery(name = "execute_seckill", procedureName = "execute_seckill", parameters = {
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "seckillId", type = Long.class),
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "userPhone", type = Long.class),
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "killTime", type = Date.class),
    @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Integer.class)
})
@Table(name = "sys_data")
public class SysData extends DrugBaseEntity {

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父节点id")
    private Integer parentId;

    @ApiModelProperty("层级")
    private LevelEnum level;

    @ApiModelProperty("排序")
    private Integer orderNo;

    @ApiModelProperty("类别 0;患教标签（患教文章），1:用户分组标签，2:咨询医生选择科室的标签，3：药品类型")
    private SysDataEnum type;
}