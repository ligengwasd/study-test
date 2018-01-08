package com.ydb;

import com.ydb.dao.repository.SysDataRepository;
import com.ydb.entity.mysql.SysData;
import org.apache.commons.lang.math.RandomUtils;
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
		for (int i=1; i<=20; i++){
			test2();
		}
	}
	@Test
	public void test2() {
		new Thread(()->{
			List<SysData> data = new ArrayList<>();
			for (int i=1; i<=100000; i++) {
				data.clear();
				for (int j=1; j<=10000; j++) {
					SysData temp =new SysData();
					temp.setLevel(RandomUtils.nextInt(3000000));// user id
					temp.setOrderNo(RandomUtils.nextInt(800000));// content id
					data.add(temp);
				}
				sysDataRepository.save(data);
			}
		}).start();
	}


}
