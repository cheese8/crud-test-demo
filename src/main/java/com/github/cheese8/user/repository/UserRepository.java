package com.github.cheese8.user.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.cheese8.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository extends BaseMapper<User> {
    
    User findByMobile(String mobile);
    
    List<User> findUsers();

    Integer saveUser(User user);

    Integer updateUser(User user);
}