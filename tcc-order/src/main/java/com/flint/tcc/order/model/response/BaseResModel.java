package com.flint.tcc.order.model.response;

import lombok.Data;

/**
 * Created by dev on 16-5-24.
 */
@Data
public class BaseResModel {
    int code=100;
    String msg;
    Object data;
    public BaseResModel(){
    }
    public BaseResModel(Integer code){
        this.code = code;
    }
}

