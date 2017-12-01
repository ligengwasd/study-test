package com.flint.tcc.order.common.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.mengyun.tcctransaction.spring.repository.SpringJdbcTransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ligeng on 17/12/1.
 */
@Configuration
public class TccConfig {
    @Bean
    public SpringJdbcTransactionRepository tccTransactionRepository(){
        SpringJdbcTransactionRepository repository = new SpringJdbcTransactionRepository();
        DruidDataSource tccDataSource = new DruidDataSource();
        tccDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/TCC");
        tccDataSource.setUsername("root");
        tccDataSource.setPassword("wasd");
        repository.setDataSource(tccDataSource);
        repository.setDomain("ORDER");
        repository.setTbSuffix("_ORD");
        return repository;
    }
}
