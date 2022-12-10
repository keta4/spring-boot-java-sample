package com.example.web.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;
    private LocalDateTime deleteDate;

    public User(Long id, String name, String address, String phone, LocalDateTime updateDate,
            LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.updateDate = updateDate;
        this.createDate = createDate;
    }

}
