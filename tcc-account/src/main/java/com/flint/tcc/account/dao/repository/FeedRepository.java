package com.flint.tcc.account.dao.repository;

import com.flint.tcc.account.entity.mysql.Feed;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ligeng on 17/9/20.
 */
public interface FeedRepository extends PagingAndSortingRepository<Feed, Long>{

}
