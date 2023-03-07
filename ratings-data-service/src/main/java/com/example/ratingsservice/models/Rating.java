package com.example.ratingsservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Rating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JsonBackReference
  private User user;
  private String movieId;

  @Min(value = 0, message = "Rating should be between 1-10")
  @Max(value = 10, message = "Rating should be between 1-10")
  private int rating;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
