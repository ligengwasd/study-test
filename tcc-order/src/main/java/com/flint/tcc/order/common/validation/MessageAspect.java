package com.flint.tcc.order.common.validation;

import com.flint.tcc.order.model.response.BaseResModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * Created by ligeng on 17/1/18.
 */
//@Aspect
//@Order(5)
public class MessageAspect {
    @Autowired
    private MessageSource messageSource;

    @Around("execution(* com.ydb.controller.*.*(..))")
    public BaseResModel addMsg(ProceedingJoinPoint pjp) throws Throwable {
//        BaseResModel resModel = (BaseResModel)pjp.proceed();
//        resModel.setMsg(messageSource.getMessage(resModel.getCode().toString(),null,"不识别的错误码，请联系服务器！",null));
        return null;
    }
}
