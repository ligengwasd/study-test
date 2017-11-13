package com.ydb.controller;

import com.ydb.entity.mysql.Feed;
import com.ydb.repository.FeedRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by ligeng on 17/1/15.
 */
@RestController
@RequestMapping
@Api(description = "测试")
public class TestController {
    @ApiOperation("测试1")
    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }

}
