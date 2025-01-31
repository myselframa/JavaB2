package com.fmc.clientexample.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.fmc.clientexample.model.BlogPostDto;

@FeignClient(name = "postClient", url = "http://localhost:8080/api")
public interface BlogPostFeignClient {
    @GetMapping("/posts/1")
    BlogPostDto getPost();
}