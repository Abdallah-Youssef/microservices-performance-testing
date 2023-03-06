# This dockerfile can be used to create images for any of the springboot microservices

# Use java version 11, alpine is a lightweight container
FROM eclipse-temurin:11-alpine

RUN mkdir /usr/app
WORKDIR /usr/app
COPY ./ ./

# Downloads maven dependencies and creates jar 
RUN ./mvnw install
CMD ["./mvnw", "spring-boot:run"]