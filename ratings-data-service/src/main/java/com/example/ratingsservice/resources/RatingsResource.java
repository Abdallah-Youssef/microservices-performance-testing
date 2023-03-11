package com.example.ratingsservice.resources;

import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.repositories.RatingsRepository;
import com.example.ratingsservice.repositories.UserRepository;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

  class MovieDAO implements Serializable {
    String movieId;
    float rating;

    public MovieDAO(String movieId, float rating) {
      this.movieId = movieId;
      this.rating = rating;
    }
  }

  @Autowired
  UserRepository userRepository;

  @Autowired
  private RatingsRepository ratingsRepository;

  @RequestMapping("/{userId}")
  public List<Rating> getRatingsOfUser(@PathVariable Long userId) {
    return ratingsRepository.getRatings(userRepository.findById(userId).get());
  }

  @RequestMapping("/top")
  public List<String> getTrendingMovies() {
    return ratingsRepository.getTrendingMovies();
    // var allRatings = ratingsRepository.findAll();

    // var count = new HashMap<String, Integer>();
    // var total = new HashMap<String, Integer>();

    // for (Rating r : allRatings) {
    //   var id = r.getMovieId();
    //   var c = count.getOrDefault(id, 0);
    //   var v = total.getOrDefault(id, 0);

    //   count.put(id, c + 1);
    //   total.put(id, v + r.getRating());
    // }

    // var avg = new HashMap<String, Double>();
    // for (String id : count.keySet()) {
    //   avg.put(id, total.get(id) * 1.0 / count.get(id));
    // }

    // return avg.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).limit(3)
    //     .map(Map.Entry::getKey).collect(Collectors.toList());
  }
}
