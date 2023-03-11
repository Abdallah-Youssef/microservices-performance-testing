# This dockerfile can be used to create images for any of the springboot microservices

# Use java version 11, alpine is a lightweight container
FROM eclipse-temurin:11

# A script that allows the container to wait until some condition
# The conditions can be defined in the docker compose
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
RUN chmod +x /wait

ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD ./trending-movies-service/pom.xml $HOME
ADD ./trending-movies-service/mvnw  $HOME
ADD ./trending-movies-service/.mvn $HOME/.mvn

# Copy gRPC classes and jar
COPY ./grpc-interface/target/ /usr/app/target/
RUN chmod 777 mvnw
RUN ./mvnw dependency:resolve


# This part is split into two different steps: dependency:resolve and package
# so that when you change the code, you don't have to redownload the dependencies

COPY ./trending-movies-service/ $HOME

# Skipping tests because running them requires access to the db which exist on the project network
# while building happens on a different network 
RUN chmod 777 mvnw
RUN ./mvnw package -Dmaven.test.skip 


# # wait for any conditions, then exectue the jar
CMD /wait && java -jar trending-movies-service-0.0.1-SNAPSHOT.jar
