package com.flint.tcc.account.controller;

import com.flint.tcc.account.feign.OrderFeignClient;
import com.flint.tcc.account.model.response.BaseResModel;
import com.flint.tcc.account.service.AccountService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by ligeng on 17/1/15.
 */
@RestController
@RequestMapping
@Api(description = "账户资金")
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private OrderFeignClient orderFeignClient;

    @GetMapping("/pay")
    public BaseResModel record(){
        try {
            return accountService.record();
        } catch (Throwable t) {
            return new BaseResModel(-99);
        }
    }

    @GetMapping("/test_log")
    public BaseResModel testLog() throws InterruptedException {
        TimeUnit.SECONDS.sleep(6);
        logger.info("测试日志跟踪 tcc-account");
        return new BaseResModel();
    }

    @GetMapping("/test_turbine")
    public BaseResModel test_turbine(){
        orderFeignClient.order();
        return new BaseResModel();
    }

}