package com.ydb.dao.repository;

import com.ydb.entity.mysql.SysData;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by ligeng on 17/9/30.
 */
public interface SysDataRepository extends PagingAndSortingRepository<SysData, Long> {
    @Procedure("execute_seckill")
    int executeSeckill(@Param("seckillId") Long seckillId,@Param("userPhone") Long userPhone,@Param("killTime") Date killTime);
}
