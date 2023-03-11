package com.example.ratingsservice.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@IdClass(Rating.class)
public class Rating implements Serializable {

  @ManyToOne
  @Id
  @JsonIgnore
  private User user;

  @Id
  @JsonIgnore
  private String movieId;

  @Min(value = 0, message = "Rating should be between 1-10")
  @Max(value = 10, message = "Rating should be between 1-10")
  private int rating;

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pk")
  public String getPk() {
    return user.getId() + "->" + movieId;
  }

  public Rating() {
  }

  public User getUser() {
    return user;
  }

  public Rating(User user, String movieId,
      @Min(value = 0, message = "Rating should be between 1-10") @Max(value = 10, message = "Rating should be between 1-10") int rating) {
    this.user = user;
    this.movieId = movieId;
    this.rating = rating;
  }

  
  

  public void setUser(User user) {
    this.user = user;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

}
