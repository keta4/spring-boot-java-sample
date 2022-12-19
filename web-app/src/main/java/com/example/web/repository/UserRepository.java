package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.entity.User;

/**
 * ユーザー情報 Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
