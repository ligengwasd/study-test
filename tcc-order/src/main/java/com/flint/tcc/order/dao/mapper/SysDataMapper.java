package com.flint.tcc.order.dao.mapper;

import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.query.Procedure;

/**
 * SysDataMapper:
 *
 * @author linwei
 */
public interface SysDataMapper {

    @Update("UPDATE sys_data SET `level` = `level` -1 WHERE id = 1 and level>0")
    int testSecKill();

    @Procedure()
    int executeSecKill();
}