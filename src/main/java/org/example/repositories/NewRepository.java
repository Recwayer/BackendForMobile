package org.example.repositories;

import org.example.models.New;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewRepository extends MongoRepository<New, Long>{

    @Query("{'title' : { '$regex': '?0', '$options': 'i' }, 'timestamp': { $gt: ?1 }}")
    List<New> findByTitleRegexAndTimestampGreaterThan(@Param("keyword") String keyword, @Param("targetTimestamp") long targetTimestamp);

    @Query("{'title' : { '$regex': '?0', '$options': 'i' }, 'timestamp': { $gt: ?1 }}")
    List<New> findByTitleRegexAndTimestampGreaterThan(@Param("keyword") String keyword, @Param("targetTimestamp") long targetTimestamp, Sort sort);

    @Query("{'title' : { '$regex': '?0', '$options': 'i' }, 'timestamp': { $gt: ?1 }}")
    Page<New> findPageByTitleRegexAndTimestampGreaterThan(@Param("keyword") String keyword, @Param("targetTimestamp") long targetTimestamp, Pageable pageable);

    @Query(value = "{ 'title' : { $regex: ?0, $options: 'i' }, 'timestamp' : { $gt: ?1 } }", exists = true)
    boolean existsByTitleRegexIgnoreCaseAndTimestampGreaterThan(String keyword, long targetTimestamp);

    @Query(value = "{ 'title' : { $regex: ?0, $options: 'i' }, 'timestamp' : { $gt: ?1 } }", count = true)
    Integer countByTitleRegexIgnoreCaseAndTimestampGreaterThan(String keyword, long targetTimestamp);
}
