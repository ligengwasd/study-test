package com.ydb.common.validation;

import com.ydb.model.response.BaseResModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

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
