package com.example.trendingmoviesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class TrendingMoviesServiceApplication {


  public static void main(String[] args) {
    SpringApplication.run(TrendingMoviesServiceApplication.class, args);
  }

}
