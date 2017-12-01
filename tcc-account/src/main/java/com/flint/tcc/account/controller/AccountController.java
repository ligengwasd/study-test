package com.flint.tcc.account.controller;

import com.flint.tcc.account.model.response.BaseResModel;
import com.flint.tcc.account.service.AccountService;
import io.swagger.annotations.Api;
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
@Api(description = "账户资金")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/pay")
    public BaseResModel record(){
        try {
            return accountService.record();
        } catch (Throwable t) {
            return new BaseResModel(-99);
        }
    }

}