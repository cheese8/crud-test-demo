package com.github.cheese8.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String username;

    private String mobile;

    private Integer age;

    public User(String username, String mobile, Integer age) {
        this.username = username;
        this.mobile = mobile;
        this.age = age;
    }
}