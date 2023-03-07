package com.example.ratingsservice.resources;

import com.example.ratingsservice.models.User;
import com.example.ratingsservice.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ratings")
public class RatingsResource {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/{userId}")
  public User getRatingsOfUser(@PathVariable Long userId) {
    User u = userRepository.findById(userId).get();
    return u;
  }
}
