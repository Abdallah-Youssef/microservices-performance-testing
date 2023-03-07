# FOR TESTING PURPOSES

FROM eclipse-temurin:11-alpine

RUN mkdir /usr/app
WORKDIR /usr/app
COPY ./ ./

RUN apk update
RUN apk add --no-cache --virtual ping nano

# docker run -it --network mysql_default test /bin/sh