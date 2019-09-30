package com.ogoma.vue_starter.vue_starter.unit;

import com.ogoma.vue_starter.vue_starter.utils.RestTemplateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(SpringJUnit4ClassRunner.class)
public class RestTemplateUtilTest {

    @InjectMocks
    RestTemplateUtil restTemplateUtil;
    @Mock
    RestTemplate restTemplate;

    @Test
    public void userCanPostFile() throws Exception {
        ResponseEntity<Object> responseEntity = mock(ResponseEntity.class);
        MockMultipartFile jsonFile = new MockMultipartFile("json", "", "application/json", "{\"json\": \"someValue\"}".getBytes());
        when(restTemplate.postForEntity(any(String.class), any(HttpEntity.class), eq(Object.class))).thenReturn(responseEntity);
        Map<String, Object> request = new HashMap<>();
        request.put("file", jsonFile);
        restTemplateUtil.makeMultipartRequestGet(request,Object.class,"/test");
    }
}
