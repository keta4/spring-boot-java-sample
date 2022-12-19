package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
