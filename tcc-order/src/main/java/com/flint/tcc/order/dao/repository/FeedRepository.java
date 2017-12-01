package com.flint.tcc.order.dao.repository;

import com.flint.tcc.order.entity.mysql.Feed;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ligeng on 17/9/20.
 */
public interface FeedRepository extends PagingAndSortingRepository<Feed, Long>{

}
