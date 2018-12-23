package com.ydb.mybatistest.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ligeng
 * @Date 18/12/21
 * @Time 下午7:32
 */
@Data
public class Post implements Serializable {
    private int id;
    private Author author;
    private String content;
}
