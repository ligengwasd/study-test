package com.ydb.dao.repository;

import com.ydb.entity.mongo.HeartBeat;
import com.ydb.entity.mysql.Feed;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ligeng on 17/12/15.
 */
public interface HeartBeatRepository extends PagingAndSortingRepository<HeartBeat, Long> {
}
