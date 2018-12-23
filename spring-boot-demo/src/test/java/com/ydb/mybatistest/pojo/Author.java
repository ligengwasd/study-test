package com.ydb.mybatistest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author ligeng
 * @Date 18/12/21
 * @Time 下午7:31
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author implements Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
}
