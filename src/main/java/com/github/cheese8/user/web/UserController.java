package com.github.cheese8.user.web;

import com.github.cheese8.infra.Result;
import com.github.cheese8.user.domain.User;
import com.github.cheese8.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/id/{id}")
    public @ResponseBody Result<?> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        return null != user ? Result.success().data(user) : new Result<>().custom(401, "The user was not found on /user/id/" + id);
    }

    @GetMapping("/user/mobile/{mobile}")
    public @ResponseBody Result<?> findUserByMobile(@PathVariable String mobile) {
        User user = userService.findByMobile(mobile);
        return null != user ? Result.success().data(user) : new Result<>().custom(401, "The user was not found on /user/mobile/" + mobile);
    }

    @GetMapping("/users")
    public @ResponseBody Result<?> findUsers() {
        List<User> users = userService.findUsers();
        return Result.success().data(users);
    }

    @PostMapping("/user")
    public @ResponseBody Result<?> saveUser(@RequestBody User user) {
        Integer result = userService.save(user);
        return Result.success().data(result);
    }

    @PutMapping("/user")
    public @ResponseBody Result<?> updateUser(@RequestBody User user) {
        Integer result = userService.update(user);
        return Result.success().data(result);
    }
}