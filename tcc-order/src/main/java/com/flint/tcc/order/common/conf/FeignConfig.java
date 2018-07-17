package com.flint.tcc.order.common.conf;

import feign.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

/**
 * Created by ligeng on 17/1/30.
 */
@Configuration
public class FeignConfig {
//    @Bean
//    public Retryer retryer(){
////        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(1L), 1);
//        return new Retryer.Default();
//    }

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }


}
