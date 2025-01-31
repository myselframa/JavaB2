package com.fmc.clientexample.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fmc.clientexample.model.BlogPostDto;

@Service
public class RestTemplateService {

    private final RestTemplate restTemplate;

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BlogPostDto getPostUsingRestTemplate() {
        String url = "http://localhost:8080/api/posts/1";
        return restTemplate.getForObject(url, BlogPostDto.class);
    }
}
