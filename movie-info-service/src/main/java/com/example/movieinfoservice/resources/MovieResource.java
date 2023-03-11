package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.MongoMovie;
import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import com.example.movieinfoservice.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    MovieRepository movieRepository;

    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    public MovieResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{movieId}")
    public MongoMovie getMovieInfo(@PathVariable("movieId") String movieId) {
        // get the data from the mongo cache
        // 1- configure the mongo client
        // 2- query it
        // if not found, get the data from the TMDB
        // save the data to the mongo cache

        // // print the mongo properties
        // System.out.println("--- host:" + mongoProperties.getHost());
        // System.out.println("--- prot:" + mongoProperties.getPort());

        // receive the movieId
        System.out.println("Received movieId: " + movieId);

        try {
            MongoMovie mongoMovie = movieRepository.findById(movieId).get();
            System.out.println("Found movie in the mongo cache: " + mongoMovie.toString());
            return mongoMovie;
        } catch (Exception e) {
            // Get the movie info from TMDB
            final String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
            MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);

            // store the movie info in the mongo cache
            movieRepository.save(new MongoMovie(movieId, movieSummary.getTitle(), movieSummary.getOverview()));

            return new MongoMovie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
        }

    }
}
