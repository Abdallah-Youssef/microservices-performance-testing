package com.example.ratingsservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.User;

public interface RatingsRepository extends JpaRepository<Rating, Rating> {
  @Query("SELECT r FROM Rating r WHERE r.user=?1")
  List<Rating> getRatings(User u);

  @Query(nativeQuery = true, value = "SELECT r.movie_id FROM rating r GROUP BY r.movie_id ORDER BY AVG(r.rating) DESC LIMIT 5")
  List<String> getTrendingMovies();

}
