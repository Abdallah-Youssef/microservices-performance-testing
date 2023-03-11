package com.example.movieinfoservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.movieinfoservice.models.MongoMovie;

public interface MovieRepository extends MongoRepository<MongoMovie, String> {

  @Query("{name:'?0'}")
  MongoMovie findItemByName(String name);

  // query by id
  @Query("{movieId:'?0'}")
  MongoMovie findItemById(String id);

  public long count();

}