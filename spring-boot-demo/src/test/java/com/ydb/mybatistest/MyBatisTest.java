package com.ydb.mybatistest;

import com.ydb.dao.mapper.SysDataMapper;
import com.ydb.entity.mysql.SysData;
import com.ydb.enums.LevelEnum;
import com.ydb.enums.SysDataEnum;
import org.apache.ibatis.executor.BaseExecutor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.CacheBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.EnumMap;

/**
 * @Author ligeng
 * @Date 18/11/28
 * @Time 下午10:47
 */
//@ActiveProfiles("development")
public class MyBatisTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
//        String resource = "mybatis-config.xml";
        InputStream inputStream = new FileInputStream("/Users/ligeng/Documents/source/study-test/spring-boot-demo/src/test/java/com/ydb/mybatistest/mybatis-config.xml");
//                Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testMyBatis() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SysDataMapper sysDataMapper = session.getMapper(SysDataMapper.class);
            SysData sysData = sysDataMapper.findById(5);
            sysDataMapper.save(new SysData(){{
                setName("name");
                setType(SysDataEnum.type1);
                setLevel(LevelEnum.type1);
            }});
            System.out.println(1);
        } finally {
            session.commit();
            session.close();
        }
    }

    public static void main(String[] args) {
        EnumMap<LevelEnum, Object> map = new EnumMap<>(LevelEnum.class);
        System.out.println(1);
    }
}
