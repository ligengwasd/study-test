package com.flint.tcc.order.controller;

import com.flint.tcc.order.dao.repository.SysDataRepository;
import com.flint.tcc.order.dao.mapper.SysDataMapper;
import com.flint.tcc.order.feign.AccountFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.context.MethodTransactionContextEditor;
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
    @Autowired
    private AccountFeignClient accountFeignClient;

    @GetMapping("/order")
    @Compensable(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder", transactionContextEditor = Compensable.DefaultTransactionContextEditor.class)
    @Transactional
    public String order(@RequestParam int flag){
        System.currentTimeMillis();
        accountFeignClient.pay();
        if (flag==1) throw new RuntimeException("ssss");
        return "success";
    }
    public void confirmOrder(int flag){
        System.out.println("confirmOrder");
    }
    public void cancelOrder(int flag){
        System.out.println("cancelOrder");
    }
}
