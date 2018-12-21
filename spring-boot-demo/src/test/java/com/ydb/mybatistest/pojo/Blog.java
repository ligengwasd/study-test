package com.ydb.mybatistest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author ligeng
 * @Date 18/12/21
 * @Time 下午7:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {
    public static String staticField;

    private int id;
    private String title;
    private Author author;
    private List<Post> posts;
}
