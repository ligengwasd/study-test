package com.flint.tcc.order.feign;

import com.flint.tcc.order.model.response.BaseResModel;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.Propagation;
import org.mengyun.tcctransaction.context.MethodTransactionContextEditor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ligeng on 17/12/1.
 */
@FeignClient(name = "tcc-account")
public interface AccountFeignClient {

    @GetMapping("/pay")
    @Compensable(propagation = Propagation.SUPPORTS, confirmMethod = "pay", cancelMethod = "pay", transactionContextEditor = Compensable.DefaultTransactionContextEditor.class)
    BaseResModel pay();

    @GetMapping("/test_log")
    BaseResModel testLog();

}