package com.github.cheese8.user.web;

import com.github.cheese8.infra.JsonAssert;
import com.github.cheese8.infra.PerformUtil;
import com.github.cheese8.user.UserBaseTest;
import com.github.cheese8.user.domain.User;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
public class UserControllerTest extends UserBaseTest {
    
    @Resource
    private MockMvc mockMvc;
    
    @Test
    public void testGetUsersSuccess() {
        // execute the service call
        ResultActions result = PerformUtil.get(mockMvc, "/users");
        // assertion
        JsonAssert.assertEquals("json/user/users.json", PerformUtil.response(result));
    }
    
    @Test
    public void testGetUserById() {
        // execute the service call
        ResultActions result = PerformUtil.get(mockMvc, "/user/id/{id}", 1L);
        // assertion
        JsonAssert.assertEquals("json/user/getUserById.json", PerformUtil.response(result));
    }

    @Test
    public void testGetUserByIdNotFound() throws Exception {
        // execute the service call
        ResultActions result = PerformUtil.get(mockMvc, "/user/id/{id}", 5L);
        // assertion
        result.andExpect(jsonPath("$.code", is(401))).andExpect(jsonPath("$.data").doesNotExist());
    }
    
    @Test
    public void testGetUserByMobile() {
        // execute the service call
        ResultActions result = PerformUtil.get(mockMvc, "/user/mobile/{mobile}", "12345678901");
        // assertion
        JsonAssert.assertEquals("json/user/getUserByMobile.json", PerformUtil.response(result));
    }
    
    @Test
    public void testGetUserByMobileNotFound() throws Exception {
        // execute the service call
        ResultActions result = PerformUtil.get(mockMvc, "/user/mobile/{mobile}", "12345678902");
        // assertion
        result.andExpect(jsonPath("$.code", is(401))).andExpect(jsonPath("$.data").doesNotExist());
    }
    
    @Test
    public void testCreateUser() {
        // execute the service call
        User user = new User("wangwu", "56789012345", 40);
        ResultActions result = PerformUtil.post(mockMvc, "/user", user);
        // assertion
        JsonAssert.assertEquals("json/user/postUser.json", PerformUtil.response(result));
    }
    
    @Test
    public void testUpdateUser() {
        // execute the service call
        User user = new User(3L,"zhangsan", "34567890123", 18);
        ResultActions result = PerformUtil.put(mockMvc, "/user", user);
        // assertion
        JsonAssert.assertEquals("json/user/putUser.json", PerformUtil.response(result));
    }
}