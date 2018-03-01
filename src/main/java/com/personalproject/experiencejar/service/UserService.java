package com.personalproject.experiencejar.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {

    private final String HEROKU_URL = "https://hj-userservice.herokuapp.com/";

    public Map<String,String> doRegistration(MultiValueMap<String, String> formData) {

        if (formData == null) {
            return new HashMap<String, String>() {
            };
        }

        final String URI = HEROKU_URL + "registration-save";

        String response;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<Map> entity = new HttpEntity<>(formData , headers);
        System.out.println(entity);

        try {
            response = restTemplate.exchange(URI, HttpMethod.POST, entity, String.class).getBody();
            System.out.println(response);
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
            return new HashMap<>();
        }



        if (response.contains("error")) {

            response = response.substring(1, response.length()-1);           //remove curly brackets
            String[] keyValuePairs = response.split(",");              //split the string to creat key-value pairs
            Map<String,String> map = new HashMap<>();

            for(String pair : keyValuePairs)                        //iterate over the pairs
            {
                String[] entry = pair.split(":");                   //split the pairs to get key and value
                map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
            }

            return map;
        }

        return null;
    }
}
