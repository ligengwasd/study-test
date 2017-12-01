package com.flint.tcc.order.service;

import com.flint.tcc.order.feign.AccountFeignClient;
import com.flint.tcc.order.model.response.BaseResModel;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ligeng on 17/12/1.
 */
@Service
public class OrderService {
    @Autowired
    private AccountFeignClient accountFeignClient;

    @Compensable(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder", transactionContextEditor = Compensable.DefaultTransactionContextEditor.class)
    @Transactional
    public BaseResModel order(@RequestParam int flag){
        System.currentTimeMillis();
        BaseResModel payRes = accountFeignClient.pay();
        if (payRes.getCode() != 100) {
            throw new RuntimeException("1234567890");
        }
        return new BaseResModel();
    }
    public void confirmOrder(int flag){
        System.out.println("confirmOrder");
    }
    public void cancelOrder(int flag){
        System.out.println("cancelOrder");
    }

}
