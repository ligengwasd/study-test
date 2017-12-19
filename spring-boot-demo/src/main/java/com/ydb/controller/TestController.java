package com.ydb.controller;

import com.ydb.dao.mapper.SysDataMapper;
import com.ydb.dao.repository.HeartBeatRepository;
import com.ydb.dao.repository.SysDataRepository;
import com.ydb.entity.mongo.HeartBeat;
import com.ydb.entity.mysql.SysData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private HeartBeatRepository heartBeatRepository;

    @ApiOperation("测试1")
    @GetMapping("/test_empty")
    public String test_empty(){
        return "test1";
    }

    @ApiOperation("测试1")
    @GetMapping("/test1")
    public String test1(){
//        sysDataMapper.testSecKill();
        Long ss = new Long(new Random().nextInt(100000));
        int i = sysDataRepository.executeSeckill(1000L, ss, new Date());
        System.out.println(i);
        return "test1";
    }
    @ApiOperation("测试mongo插入性能")
    @GetMapping("/testMongoInsert")
    public HeartBeat testMongoInsert(){
        HeartBeat hb = new HeartBeat();
        hb.setUId(new Random().nextInt());
        hb.setUId(new Random().nextLong());
        heartBeatRepository.save(hb);
        return hb;
    }
    @ApiOperation("testMybatisCache")
    @GetMapping("/testMybatisCache")
    public SysData testMybatisCache(@RequestParam long id){
        SysData sysData = sysDataMapper.findById(id);
        return sysData;
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            Long ss = new Long(new Random().nextInt(100000));
            System.out.println(ss);
        }
    }

}
