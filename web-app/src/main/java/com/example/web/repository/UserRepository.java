package com.example.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.entity.User;

/**
 * ユーザー情報 Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameIgnoreCaseContaining(String name);

}
