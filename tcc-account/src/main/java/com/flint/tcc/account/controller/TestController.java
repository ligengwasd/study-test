package com.flint.tcc.account.controller;

import com.flint.tcc.account.dao.repository.SysDataRepository;
import com.flint.tcc.account.dao.mapper.SysDataMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

/**
 * Created by ligeng on 17/1/15.
 */
@RestController
@RequestMapping
@Api(description = "测试")
public class TestController {
    @Autowired
    private SysDataMapper sysDataMapper;
    @Autowired
    private SysDataRepository sysDataRepository;

    @ApiOperation("测试1")
    @GetMapping("/test1")
    public String test1(){
//        sysDataMapper.testSecKill();
        Long ss = new Long(new Random().nextInt(100000));
        int i = sysDataRepository.executeSeckill(1000L, ss, new Date());
        System.out.println(i);
        return "test1";
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            Long ss = new Long(new Random().nextInt(100000));
            System.out.println(ss);
        }
    }

}
