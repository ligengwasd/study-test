package com.ydb.dao.mapper;

import com.ydb.entity.mysql.SysData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.query.Procedure;

/**
 * SysDataMapper:
 *
 * @author linwei
 */
public interface SysDataMapper {
    @Cacheable("sysDataCache")
    SysData findById(@Param("id") long id);

    int save(SysData entity);

//    @Update("UPDATE sys_data SET `level` = `level` -1 WHERE id = 1 and level>0")
//    int testSecKill();
//
//    @Procedure()
//    int executeSecKill();

}