package com.travelbloom.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    private static final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private JsonUtil() {
    }

    // Convert Java object to JSON
    public static String toJson(Object object) {

        return gson.toJson(object);
    }

    // Convert JSON to Java object
    public static <T> T fromJson(
            String json,
            Class<T> classType) {

        return gson.fromJson(json, classType);
    }
}