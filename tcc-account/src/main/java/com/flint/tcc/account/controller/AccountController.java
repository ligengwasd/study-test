package com.flint.tcc.account.controller;

import com.flint.tcc.account.dao.repository.SysDataRepository;
import com.flint.tcc.account.dao.mapper.SysDataMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.context.MethodTransactionContextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@Api(description = "账户资金")
public class AccountController {

    @GetMapping("/pay")
    @Compensable(confirmMethod = "confirmRecord", cancelMethod = "cancelRecord", transactionContextEditor = MethodTransactionContextEditor.class)
    @Transactional
    public String record(){
        return "success";
    }
    public void confirmRecord(){
        System.out.println("confirmRecord");
    }
    public void cancelRecord(){
        System.out.println("cancelRecord");

    }

}
