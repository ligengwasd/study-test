package com.flint.tcc.account.common.validation;

import com.flint.tcc.account.model.response.BaseResModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * Created by dev on 16-5-24.
 */

//@Aspect
//@Order(30)
public class ValidAspect {

    @Around("execution(* com.ydb.controller.*.*(..,@javax.validation.Valid (*), org.springframework.validation.BindingResult,..))")
    public BaseResModel doValid(ProceedingJoinPoint pjp) throws Throwable {
        return null;
    }
}
