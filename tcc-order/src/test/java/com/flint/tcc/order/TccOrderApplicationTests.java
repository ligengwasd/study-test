package com.flint.tcc.order;

import com.flint.tcc.order.dao.repository.SysDataRepository;
import com.flint.tcc.order.feign.AccountFeignClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TccOrderApplicationTests {
	@Autowired
	private SysDataRepository sysDataRepository;
	@Autowired
	private AccountFeignClient accountFeignClient;

	@Test
	public void contextLoads() {
		int i = sysDataRepository.executeSeckill(1000l,15121128676l, new Date());
		System.out.println(i);
	}
	@Test
	public void tesLog() {
		accountFeignClient.testLog();
	}
}
