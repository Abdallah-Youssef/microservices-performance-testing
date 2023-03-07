package com.example.ratingsservice.services;


import java.util.List;
import com.example.ratingsservice.models.User;

public interface UserService {
  void save(User person);

  List<User> getPersonList();
}

