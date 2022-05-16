package com.wevibe.project.geolocation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wevibe.project.geolocation.models.Context;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonInput {

    public Context parseFromJson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        BufferedReader br = new BufferedReader(new FileReader(path));
        return objectMapper.readValue(br, Context.class);
    }
}
