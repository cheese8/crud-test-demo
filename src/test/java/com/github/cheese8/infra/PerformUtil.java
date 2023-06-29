package com.github.cheese8.infra;

import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

public class PerformUtil {
    
    @SneakyThrows(Exception.class)
    public static ResultActions get(MockMvc mockMvc, String uri, Object... uriVars) {
        return mockMvc.perform(MockMvcRequestBuilders.get(uri, uriVars));
    }
    
    @SneakyThrows(Exception.class)
    public static <T> ResultActions post(MockMvc mockMvc, String uri, T t) {
        return mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(t)));
    }
    
    @SneakyThrows(Exception.class)
    public static <T> ResultActions put(MockMvc mockMvc, String uri, T t) {
        return mockMvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(t)));
    }
    
    @SneakyThrows(UnsupportedEncodingException.class)
    public static String response(ResultActions result) {
        return result.andReturn().getResponse().getContentAsString();
    }

    private PerformUtil() {}
}