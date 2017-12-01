package com.flint.tcc.order.feign;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.Propagation;
import org.mengyun.tcctransaction.context.MethodTransactionContextEditor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ligeng on 17/12/1.
 */
@FeignClient(name = "accountFeignClient", url = "http://localhost:9092")
public interface AccountFeignClient {

    @GetMapping("/pay")
    @Compensable(propagation = Propagation.SUPPORTS, confirmMethod = "pay", cancelMethod = "pay", transactionContextEditor = MethodTransactionContextEditor.class)
    public String pay();
}
