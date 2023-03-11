package com.example.movieinfoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.example.movieinfoservice.models.MongoMovie;
import com.example.movieinfoservice.repositories.MovieRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableMongoRepositories
@EnableAutoConfiguration
public class MovieInfoServiceApplication {

    private final int TIMEOUT = 3000; // 3 seconds

    @Autowired
    MovieRepository movieRepository;

    @Bean
    public RestTemplate getRestTemplate() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(TIMEOUT); // Set the timeout to 3 seconds
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieInfoServiceApplication.class, args);
    }

    void createMovie() {
        MongoMovie movie = new MongoMovie("1234", "Test Movie", "Test Description");
        movieRepository.save(movie);
        movieRepository.save(movie);
        movieRepository.save(movie);
    }

    // 1. Show all the data
    public void showAllGroceryItems() {

        movieRepository.findAll().forEach((item) -> System.out.println(item.toString()));
    }

    // 2. Get item by name
    public void getGroceryItemByName(String name) {
        System.out.println("Getting item by name: " + name);
        MongoMovie item = movieRepository.findItemByName(name);
        System.out.println(item.toString());
    }

    // 3. Get item by id
    public void getGroceryItemById(String id) {
        System.out.println("Getting item by id: " + id);
        MongoMovie item = movieRepository.findItemById(id);
        System.out.println(item.toString());
    }

}
