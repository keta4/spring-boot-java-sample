package com.example.web.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.web.entity.User;

@Service
public class UserService {

    private ArrayList<User> supplyUserList() {
        var userlist = new ArrayList<User>();

        var phone = "090-1234-1234";
        var address = "東京都渋谷区1-1";
        var updateDate = LocalDateTime.of(2022, 12, 2, 0, 0, 0);
        var createDate = LocalDateTime.of(2022, 12, 1, 0, 0, 0);

        var Alice = new User(1L, "Alice", address, phone, updateDate, createDate);
        var Bob = new User(2L, "Bob", address, phone, updateDate, createDate);
        var Carol = new User(3L, "Carol", address, phone, updateDate, createDate);

        userlist.add(Alice);
        userlist.add(Bob);
        userlist.add(Carol);

        return userlist;
    }

    public ArrayList<User> searchAll() {
        return supplyUserList();
    }

    public User findById(Long id) {
        var userlist = supplyUserList();

        var foundUser = userlist.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .get();

        return foundUser;
    }

}
