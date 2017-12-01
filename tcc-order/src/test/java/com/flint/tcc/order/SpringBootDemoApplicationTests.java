package com.flint.tcc.order;

import com.flint.tcc.order.dao.repository.SysDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {
	@Autowired
	private SysDataRepository sysDataRepository;

	@Test
	public void contextLoads() {
		int i = sysDataRepository.executeSeckill(1000l,15121128676l, new Date());
		System.out.println(i);
	}

}
