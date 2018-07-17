package com.flint.tcc.order.feign.hystrix;

import com.flint.tcc.order.feign.AccountFeignClient;
import com.flint.tcc.order.model.response.BaseResModel;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

/**
 * Created by ligeng on 17/12/1.
 */
@Slf4j
@Component
public class AccountFeignClientHystrix implements FallbackFactory<AccountFeignClient> {
    @Override
    public AccountFeignClient create(Throwable throwable) {
        log.error("AccountFeignClientHystrix fallback, cause{}", ExceptionUtils.getMessage(throwable));
        return new AccountFeignClient() {
            @Override
            public BaseResModel pay() {
                return null;
            }

            @Override
            public BaseResModel testLog() {
                return null;
            }
        };
    }
}