package com.example.trendingmoviesservice.services;

import com.hambola.*;
import com.hambola.TrendingMovies.Builder;
import com.hambola.TrendingMovies.Movie;

import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.web.client.RestTemplate;

@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

  private RestTemplate restTemplate;

  @Override
  public void getTrendingMovies(com.hambola.Empty request,
      io.grpc.stub.StreamObserver<com.hambola.TrendingMovies> responseObserver) {
        
    Movie movie1 = Movie.newBuilder().setMovieId("Movie 1").setRating((float) 9.5).build();
    Movie movie2 = Movie.newBuilder().setMovieId("Movie 2").setRating((float) 5.9).build();
    Movie movie3 = Movie.newBuilder().setMovieId("Movie 3").setRating((float) 4.2).build();

    final String url = "https://ratings-data-service/3/movie/" + movieId + "?api_key=" + apiKey;
    MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);

    return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

    Movie[] movies = new Movie[]{
      movie1,
      movie2,
      movie3
    };

    Builder trendingMovies = TrendingMovies.newBuilder();
    for (Movie movie: movies) {
      trendingMovies.addMovies(movie);
    }

    responseObserver.onNext(trendingMovies.build());
    responseObserver.onCompleted();
  }

}