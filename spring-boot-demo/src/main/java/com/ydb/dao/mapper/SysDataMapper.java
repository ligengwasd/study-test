package com.ydb.dao.mapper;

import org.apache.ibatis.annotations.Update;
/**
 * SysDataMapper:
 *
 * @author linwei
 */
public interface SysDataMapper {

    @Update("UPDATE sys_data SET `level` = `level` -1 WHERE id = 1 and level>0")
    int testSecKill();
}