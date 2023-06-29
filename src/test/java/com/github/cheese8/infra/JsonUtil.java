package com.github.cheese8.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    
    private final static ObjectMapper om = new ObjectMapper();
    
    @SneakyThrows(JsonProcessingException.class)
    public static <T> String toJson(final T t) {
        om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return om.writeValueAsString(t);
    }
    
    @SneakyThrows(IOException.class)
    public static String fromFile(String filePath, Charset charset) {
        File file = new ClassPathResource(filePath).getFile();
        return new String(Files.readAllBytes(file.toPath()), charset);
    }

    @SneakyThrows(JsonProcessingException.class)
    public static <T> T toObject(String json, Class<T> clazz) {
        return om.readValue(json, clazz);
    }
    
    public static Map<String, Object> toMap(String json) {
        return toObject(json, Map.class);
    }

    @SneakyThrows({ClassNotFoundException.class, JsonProcessingException.class})
    public static <T> List<T> toArray(String json, Class<T> clazz) {
        Class<T[]> arrayOfClass = (Class<T[]>) Class.forName(String.format("[L%s;", clazz.getName()));
        return Arrays.asList(om.readValue(json, arrayOfClass));
    }
    
    private JsonUtil() {}
}