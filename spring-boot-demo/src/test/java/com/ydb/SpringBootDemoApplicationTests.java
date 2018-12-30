package com.ydb;

import com.ydb.dao.repository.SysDataRepository;
import com.ydb.entity.mysql.SysData;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.builder.xml.XMLStatementBuilder;
import org.apache.ibatis.mapping.MappedStatement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {
	@Autowired
	private SysDataRepository sysDataRepository;

	@Test
	public void contextLoads() {
//		int i = sysDataRepository.executeSeckill(1000l,15121128676l, new Date());
//		System.out.println(i);
		test2();
	}
	@Test
	public void test2() {
//		MapperMethod.SqlCommand
//		MappedStatement
//		XMLStatementBuilder

	}


}
