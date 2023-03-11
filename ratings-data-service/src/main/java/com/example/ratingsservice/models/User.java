package com.example.ratingsservice.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id;

  private String name;

  @OneToMany(mappedBy = "user")
  private List<Rating> ratings;

  public User() {
  }

  public User(Long id, String name, List<Rating> ratings) {
    this.id = id;
    this.name = name;
    this.ratings = ratings;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Rating> getRatings() {
    return ratings;
  }

  public void setRatings(List<Rating> ratings) {
    this.ratings = ratings;
  }

  
  

}
