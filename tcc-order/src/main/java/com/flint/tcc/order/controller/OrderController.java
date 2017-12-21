package com.flint.tcc.order.controller;

import com.flint.tcc.order.dao.repository.SysDataRepository;
import com.flint.tcc.order.dao.mapper.SysDataMapper;
import com.flint.tcc.order.feign.AccountFeignClient;
import com.flint.tcc.order.model.response.BaseResModel;
import com.flint.tcc.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.context.MethodTransactionContextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@Api(description = "订单")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountFeignClient accountFeignClient;

    @GetMapping("/order")
    public BaseResModel order(@RequestParam int flag){
        BaseResModel orderRes;
        try {
            orderRes = orderService.order(flag);
        } catch (Throwable t) {
            return new BaseResModel(-99);
        }
        return orderRes;
    }

    @GetMapping("/test_log")
    public BaseResModel testLog(){
        logger.info("测试日志跟踪 tcc-order");
        return accountFeignClient.testLog();
    }
}
