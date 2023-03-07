-- This SQL file will run if the data isn't intialized

CREATE TABLE user (
  id INT AUTO_INCREMENT,
  name VARCHAR(50),
  CONSTRAINT PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE rating (
  id INT AUTO_INCREMENT,
  movieId VARCHAR(255) NOT NULL,
  rating TINYINT NOT NULL CHECK (rating >= 0 AND rating <= 10),
  userId INT,
  
  CONSTRAINT PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (userId) REFERENCES user(id)
) ENGINE=INNODB;

INSERT INTO user (name)
VALUES ("bahgat"), ("moaz"), ("abdallah");

INSERT INTO rating (movieId, rating, userId)
VALUES ("299534", 10, 1), ("299534", 7, 2), ("299534", 9, 3),-- Avengers: Endgame
      ("299536", 8, 1), ("299536", 0, 2), ("299536", 10, 3);  -- Avengers: Infinity War
