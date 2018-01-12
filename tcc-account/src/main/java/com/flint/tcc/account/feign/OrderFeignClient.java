package com.flint.tcc.account.feign;

import com.flint.tcc.account.model.response.BaseResModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ligeng on 17/12/1.
 */
@FeignClient(name = "tcc-order")
public interface OrderFeignClient {
    @GetMapping("/order")
    BaseResModel order();
}