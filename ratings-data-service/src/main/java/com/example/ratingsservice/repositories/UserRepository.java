package com.example.ratingsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ratingsservice.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}