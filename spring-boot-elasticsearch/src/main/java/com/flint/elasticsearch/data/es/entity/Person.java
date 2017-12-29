package com.flint.elasticsearch.data.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by ligeng on 17/12/29.
 */
@Data
@Document(indexName = "ydb", type = "person")
public class Person {
    @Id
    private Long id;
    private String name;
}