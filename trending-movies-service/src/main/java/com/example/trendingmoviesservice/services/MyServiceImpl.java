package com.example.trendingmoviesservice.services;

import com.hambola.*;
import com.hambola.TrendingMovies.Builder;

import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

  @Override
  public void getTrendingMovies(com.hambola.Empty request,
      io.grpc.stub.StreamObserver<com.hambola.TrendingMovies> responseObserver) {

    final String url = "http://localhost:8083/ratings/top/";
    final RestTemplate restTemplate = new RestTemplate();

    String[] l = restTemplate.getForObject(url, String[].class);

    Builder trendingMovies = TrendingMovies.newBuilder();
    for (String movie : l) {
      trendingMovies.addMovieId(movie);
    }

    responseObserver.onNext(trendingMovies.build());
    responseObserver.onCompleted();
  }

}