package com.fmg.blog.payloads;

import java.util.List;

import com.fmg.blog.dto.BlogPostDto;

import lombok.Data;

@Data
public class BlogPostResponse {
	
	
	private List<BlogPostDto> blogPost;
	private int pageNo;
	private int pageSize;
	private int totalElements;
	private int totalPages;
	private boolean last;

}
