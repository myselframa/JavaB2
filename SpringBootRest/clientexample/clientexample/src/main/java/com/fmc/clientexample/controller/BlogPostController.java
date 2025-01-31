package com.fmc.clientexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmc.clientexample.config.BlogPostFeignClient;
import com.fmc.clientexample.model.BlogPostDto;
import com.fmc.clientexample.service.RestTemplateService;
import com.fmc.clientexample.service.WebClientService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class BlogPostController {

    private final WebClientService webClientService;
    private final RestTemplateService restTemplateService;
    private final BlogPostFeignClient postFeignClient;

    public BlogPostController(WebClientService webClientService, RestTemplateService restTemplateService,
			BlogPostFeignClient postFeignClient) {
		super();
		this.webClientService = webClientService;
		this.restTemplateService = restTemplateService;
		this.postFeignClient = postFeignClient;
	}

	@GetMapping("/blogpost/webclient")
    public Mono<BlogPostDto> getPostWithWebClient() {
        return webClientService.getPostUsingWebClient();
    }

    @GetMapping("/blogpost/resttemplate")
    public BlogPostDto getPostWithRestTemplate() {
        return restTemplateService.getPostUsingRestTemplate();
    }

    @GetMapping("/blogpost/feign")
    public BlogPostDto getPostWithFeign() {
        return postFeignClient.getPost();
    }
}