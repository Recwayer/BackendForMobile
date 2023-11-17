package org.example.repositories;

import org.example.models.NewRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRatingRepository extends CrudRepository<NewRating,Long> {

}