package com.java.hibernate.util;

import tools.jackson.databind.ObjectMapper;

import java.util.stream.IntStream;

public class Utils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String bioData() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 30).forEach(i -> sb.append("This is a dummy biodata"));
        return sb.toString();
    }

    public static String toJson(Object object) {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}
