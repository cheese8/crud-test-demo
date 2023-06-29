package com.github.cheese8.user.service;

import com.github.cheese8.user.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByMobile(String mobile);
    List<User> findUsers();
    Integer save(User user);
    Integer update(User user);
}