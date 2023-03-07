# This dockerfile can be used to create images for any of the springboot microservices

# Use java version 11, alpine is a lightweight container
FROM eclipse-temurin:11-alpine

# A script that allows the container to wait until some condition
# The conditions can be defined in the docker compose
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
RUN chmod +x /wait

RUN mkdir /usr/app
WORKDIR /usr/app
COPY ./ ./


# Downloads maven dependencies and creates jar, leave it as a step to be cached 
RUN ./mvnw install

# wait for any conditions, then exectue the jar in  ./target
CMD /wait && java -jar $(find ./target -name \*.jar)
