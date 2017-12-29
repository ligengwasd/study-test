package com.flint.elasticsearch.data.es.repository;

import com.flint.elasticsearch.data.es.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by ligeng on 17/12/29.
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{
}