package com.github.cheese8.user.service;

import com.github.cheese8.user.repository.UserRepository;
import com.github.cheese8.user.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserRepository userRepository;
    
    @Override
    public User findById(final Long id) {
        return userRepository.selectById(id);
    }
    
    @Override
    public User findByMobile(final String mobile) {
        return userRepository.findByMobile(mobile);
    }
    
    @Override
    public List<User> findUsers() {
        return userRepository.findUsers();
    }
    
    @Override
    public Integer save(User user) {
        return userRepository.saveUser(user);
    }
    
    @Override
    public Integer update(final User user) {
        return userRepository.updateUser(user);
    }
}