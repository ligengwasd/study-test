package com.ydb.entity.mongo;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


/**
 * Created by ligeng on 17/12/15.
 */
@Data
@Document
public class HeartBeat {
    @Id
    private String id;
    private long uId;// User id
    private long ts;// 时间戳
}
