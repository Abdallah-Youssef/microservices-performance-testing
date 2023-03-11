package com.example.movieinfoservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class MongoMovie {

  @Id
  private String movieId;
  private String name;
  private String description;

  public MongoMovie(String movieId, String name, String description) {
    super();
    this.movieId = movieId;
    this.name = name;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
