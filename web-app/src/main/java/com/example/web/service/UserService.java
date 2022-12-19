package com.example.web.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.web.dto.UserRequest;
import com.example.web.entity.User;
import com.example.web.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    /**
     * ユーザー情報 Repository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザー情報 全件取得
     *
     * @return 全ユーザー
     */
    public List<User> searchAll() {
        return userRepository.findAll();
    }

    /**
     * ユーザー情報 ID検索
     *
     * @param id
     * @return マッチしたユーザー
     */
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    /**
     * ユーザー新規登録
     * 
     * @param userRequest
     */
    public void create(UserRequest userRequest) {
        var now = LocalDateTime.now();
        User user = new User();
        user.setName(userRequest.getName());
        user.setAddress(userRequest.getAddress());
        user.setPhone(userRequest.getPhone());
        user.setCreateDate(now);
        user.setUpdateDate(now);
        userRepository.save(user);
    }
}
