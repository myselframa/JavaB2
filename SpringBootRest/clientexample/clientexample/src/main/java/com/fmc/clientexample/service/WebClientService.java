package com.fmc.clientexample.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.fmc.clientexample.model.BlogPostDto;

import reactor.core.publisher.Mono;

@Service
public class WebClientService {

    private final WebClient webClient;

    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/api").build();
    }

    public Mono<BlogPostDto> getPostUsingWebClient() {
        return webClient.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(BlogPostDto.class);
    }
}