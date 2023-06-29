package com.github.cheese8.infra;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class JsonAssert {
    
    @SneakyThrows
    public static void assertEquals(String expectedJson, String actualJson) {
        if (!JsonUtil.fromFile(expectedJson, StandardCharsets.UTF_8).equalsIgnoreCase(actualJson)) {
            throw new Exception("Contents in [" + expectedJson +  "] was not match the response.\n" + actualJson);
        }
    }
    
    @SneakyThrows
    public static <E, A> void assertSame(E expected, A actual) {
        String expectedJson = JsonUtil.toJson(expected);
        String actualJson = JsonUtil.toJson(actual);
        if (!Objects.equals(expectedJson, actualJson)) {
            throw new Exception("The expected contents\n" + expectedJson +  "\nwas not match the actual.\n" + actualJson);
        }
    }

    private JsonAssert() {}
}