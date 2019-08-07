package com.ogoma.vue_starter.vue_starter.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
}
