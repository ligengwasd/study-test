package com.ydb.mybatistest.pojo;

import lombok.Data;

/**
 * @Author ligeng
 * @Date 18/12/21
 * @Time 下午7:32
 */
@Data
public class Post {
    private int id;
    private Author author;
    private String content;
}
