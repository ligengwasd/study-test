package com.flint.tcc.account.service;

import com.flint.tcc.account.model.response.BaseResModel;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ligeng on 17/12/1.
 */
@Service
public class AccountService {

    @Compensable(confirmMethod = "confirmRecord", cancelMethod = "cancelRecord", transactionContextEditor = Compensable.DefaultTransactionContextEditor.class)
    @Transactional
    public BaseResModel record(){
        if (1==1) throw new RuntimeException("ssss");
        return new BaseResModel();
    }
    public void confirmRecord(){
        System.out.println("confirmRecord");
    }
    public void cancelRecord(){
        System.out.println("cancelRecord");
    }
}
