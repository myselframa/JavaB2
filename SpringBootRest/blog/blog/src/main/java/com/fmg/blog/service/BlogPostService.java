package com.fmg.blog.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.fmg.blog.dto.BlogPostDto;

public interface BlogPostService {

	BlogPostDto createblogPost(BlogPostDto blogpostdto);
	
	BlogPostDto findByBlogPostId(Integer id);
	
	List<BlogPostDto> getAllBlogPost(Pageable page);
	
	BlogPostDto updateBlogPost(BlogPostDto blogpostdto);
	
	void deletePostById(Integer id);
}
