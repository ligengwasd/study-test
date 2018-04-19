package com.ydb.mapper;

import com.ydb.dao.mapper.SysDataMapper;
import com.ydb.entity.mysql.SysData;
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
        System.out.println(sysDataMapper.save(entity));
    }
}
