package com.example.web.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.web.dto.CreateUserRequestBody;
import com.example.web.dto.SearchUserRequestBody;
import com.example.web.dto.UpdateUserRequestBody;
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
     * @return すべてのユーザーのリスト
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
     * ユーザー情報 名前検索
     *
     * @param name
     * @return マッチしたユーザーのリスト
     */
    public List<User> findByName(SearchUserRequestBody searchUserRequestBody) {

        String name = searchUserRequestBody.getName();
        return userRepository.findByNameIgnoreCaseContaining(name);

    }

    /**
     * ユーザー新規登録
     *
     * @param createUserRequestBody
     */
    public void create(CreateUserRequestBody createUserRequestBody) {

        var now = LocalDateTime.now();
        User user = new User();
        user.setName(createUserRequestBody.getName());
        user.setAddress(createUserRequestBody.getAddress());
        user.setPhone(createUserRequestBody.getPhone());
        user.setCreateDate(now);
        user.setUpdateDate(now);
        userRepository.save(user);

    }

    /**
     * ユーザー情報編集
     *
     * @param updateUserRequestBody
     */
    public void update(UpdateUserRequestBody updateUserRequestBody) {

        var now = LocalDateTime.now();
        User user = findById(updateUserRequestBody.getId());
        user.setName(updateUserRequestBody.getName());
        user.setAddress(updateUserRequestBody.getAddress());
        user.setPhone(updateUserRequestBody.getPhone());
        user.setUpdateDate(now);
        userRepository.save(user);

    }

    /**
     * ユーザー削除
     *
     * @param id
     */
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
