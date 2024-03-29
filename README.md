# spring-boot-microservices
In this project, multiple microservices communicate with each other to provide the backend services of a minimalistic/sample movie rating application similar to IMDB.

## Technologies

- Spring Boot
- Spring Cloud Eureka (Service Discovery)
- Spring Cloud Hystrix (Dashboard, Circuit Breaker pattern, Bulkhead pattern)

## Summary

*  __MovieInfoService__ provides the movie info by sending requests to __TheMovieDB API__. 
* __RatingsDataService__ provides the user's ratings for movies.
* __MovieCatalogService__ acts as an accumulator that gets data from __RatingsDataService__ and __MovieInfoService__ to present it.
* __DiscoveryServer__ is the Eureka server for service discovery.
* __gRPC__ grpcurl --plaintext -d "{}" localhost:9090 com.hambola.MyService/GetTrendingMovies

![Screen Shot 2021-09-23 at 16 48 57](https://user-images.githubusercontent.com/22833948/134519062-0013cbf9-8a5f-4a43-ba14-635ccdbab04b.png)

## Running
1- First create the network: `docker network create --driver bridge project` \
2- Start up the database, see the [README in the mysql directory](https://github.com/Abdallah-Youssef/microservices-performance-testing/tree/main/mysql) \
3- Start up the services:

Running `docker compose up` will build images for all the services and start them all up. Initially it will take some time to download the base image and run mvnw install, but after that everything will be cached (until you change the code, then mvnw install will rerun). 

* Discovery Server - http://localhost:8761
* Movie Catalog - http://localhost:8081/catalog/{userId}
* Movie Info - http://localhost:8082/movies/{movieId}
* Ratings Data - http://localhost:8083/ratings/{userId}
* Hystrix Dashboard - Go to http://localhost:8081/hystrix. Then enter *https://localhost:8081/actuator/hystrix.stream* to the inputbox.
