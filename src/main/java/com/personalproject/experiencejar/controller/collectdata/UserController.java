package com.personalproject.experiencejar.controller.collectdata;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserController {

    private final String HEROKU_URL = "https://hj-userservice.herokuapp.com/";

    public List<String> doRegistration(MultiValueMap<String, String> formData) {

        if (formData == null) {
            return new ArrayList<>();
        }

        final String URI = HEROKU_URL + "registration";

        String response;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<Map> entity = new HttpEntity<>(formData , headers);

        try {
            response = restTemplate.exchange(URI, HttpMethod.POST, entity, String.class).getBody();
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

        if (jsonObject.has("error")) {
            return gson.fromJson(jsonObject.get("error"), ArrayList.class);
        }

        return null;
    }
}
