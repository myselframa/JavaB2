package com.fmg.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmg.blog.dto.BlogPostDto;
import com.fmg.blog.service.BlogPostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {
	
	private BlogPostService blogPostService;
	 
	public BlogPostController(BlogPostService blogPostService) {
		super();
		this.blogPostService = blogPostService;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	@SecurityRequirement(
            name = "Bear Authentication"
    )
	@Operation(
            summary = "Create BlogPost REST API",
            description = "Create BlogPost REST API is used to save post into database"
    )
	@ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )

	public ResponseEntity<BlogPostDto> createBlog(@Valid @RequestBody BlogPostDto bloppost){
		
		BlogPostDto createblogPost = blogPostService.createblogPost(bloppost);
		
		return new ResponseEntity(createblogPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<BlogPostDto> findBlogPostById(@PathVariable("postId") Long id){
		BlogPostDto findByBlogPostId = blogPostService.findByBlogPostId(id);
		return new ResponseEntity(findByBlogPostId,HttpStatus.OK); 
	}
	
	@GetMapping
	public ResponseEntity<BlogPostDto> getAllBlogPost(){
		List<BlogPostDto> allBlogPost = blogPostService.getAllBlogPost();
		return new ResponseEntity(allBlogPost,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<BlogPostDto> updateBlogPost(@Valid @RequestBody BlogPostDto bloppostdto){
		BlogPostDto updateBlogPost = blogPostService.updateBlogPost(bloppostdto);
		return new ResponseEntity(updateBlogPost,HttpStatus.OK);
	}
	
	// delete post rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id){

    	blogPostService.deletePostById(id);

        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
	

	
}
