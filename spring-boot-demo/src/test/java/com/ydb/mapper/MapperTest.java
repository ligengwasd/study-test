package com.ydb.mapper;

import com.ydb.dao.mapper.SysDataMapper;
import com.ydb.entity.mysql.SysData;
import com.ydb.enums.LevelEnum;
import com.ydb.enums.SysDataEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    private SysDataMapper sysDataMapper;

    @Test
    public void save(){
        SysData entity = new SysData();
        entity.setName("ligeng");
        entity.setType(SysDataEnum.type1);
        entity.setLevel(LevelEnum.type1);
        System.out.println(sysDataMapper.save(entity));
    }

    @Test
    public void find(){
        SysData entity = sysDataMapper.findById(3L);
        System.out.println(entity);
    }
}
