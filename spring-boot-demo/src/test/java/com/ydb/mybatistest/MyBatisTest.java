package com.ydb.mybatistest;

import com.ydb.dao.mapper.SysDataMapper;
import com.ydb.entity.mysql.SysData;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author ligeng
 * @Date 18/11/28
 * @Time 下午10:47
 */
@ActiveProfiles("development")
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
            SysData sysData = sysDataMapper.findById(169452);
            System.out.println(1);
        } finally {
            session.commit();
            session.close();
        }
    }
}
