package com.ogoma.vue_starter.vue_starter.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RestTemplateUtil<R> {
    @Autowired
    private RestTemplate restTemplate;
    public <T, R extends Object> R makeRequestPost(T requestBody, R response, Map<String, String> headers,String url) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        final HttpEntity<T> entity =
                new HttpEntity<>(requestBody, httpHeaders);
        ResponseEntity<R> result = (ResponseEntity<R>) restTemplate.exchange( url, HttpMethod.POST, entity, response.getClass());
        return result.getBody();
    }
    public <T, R> R makeRequestGet(T requestBody, R response, Map<String, String> headers,String url) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        final HttpEntity<T> entity =
                new HttpEntity<>(requestBody, httpHeaders);
        ResponseEntity<R> result = (ResponseEntity<R>) restTemplate.exchange( url, HttpMethod.GET, entity, response.getClass());
        return result.getBody();
    }

    public <T, R> R makeMultipartRequestGet(T requestBody, Class<R>  response,String url) throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        bodyMap= objectMapper.readValue(objectMapper.writeValueAsString(requestBody),MultiValueMap.class);
      //  BeanUtils.copyProperties(requestBody, bodyMap);
        final HttpEntity<MultiValueMap<String, Object>> entity =
                new HttpEntity<>(bodyMap, httpHeaders);
        ResponseEntity<R> result = (ResponseEntity<R>) restTemplate.patchForObject( url, entity, response);
        return result.getBody();
    }
}
