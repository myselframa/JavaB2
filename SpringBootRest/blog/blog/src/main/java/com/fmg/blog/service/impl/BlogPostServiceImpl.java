package com.fmg.blog.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fmg.blog.dto.BlogPostDto;
import com.fmg.blog.entites.BlogPost;
import com.fmg.blog.exception.ResourceNotFoundException;
import com.fmg.blog.payloads.BlogPostResponse;
import com.fmg.blog.repo.BlogPostRepo;
import com.fmg.blog.service.BlogPostService;
@Service
public class BlogPostServiceImpl implements BlogPostService{

	private BlogPostRepo blogPostRepo;
	
	@Autowired
	public BlogPostServiceImpl(BlogPostRepo blogPostRepo) {
		super();
		this.blogPostRepo = blogPostRepo;
	}



	@Override
	public BlogPostDto createblogPost(BlogPostDto blogpostdto) {
		  BlogPost save = blogPostRepo.save(mapDtoToEntity(blogpostdto));
		  return mapEntityToDto(save);
	}
	
	private BlogPost mapDtoToEntity(BlogPostDto blogpostdto) {
		
		BlogPost blogPost=new BlogPost();
		blogPost.setContent(blogpostdto.getContent());
		blogPost.setDiscription(blogpostdto.getDiscription());
		blogPost.setTitle(blogpostdto.getTitle());
		blogPost.setBlogId(blogpostdto.getBlogId());
		return blogPost;
	}
	
	private BlogPostDto mapEntityToDto(BlogPost blogpost) {
		
		BlogPostDto blogPostDto=new BlogPostDto();
		blogPostDto.setContent(blogpost.getContent());
		blogPostDto.setDiscription(blogpost.getDiscription());
		blogPostDto.setTitle(blogpost.getTitle());
		blogPostDto.setBlogId(blogpost.getBlogId());
		return blogPostDto;
	}



	@Override
	public BlogPostDto findByBlogPostId(Integer id) {
		Optional<BlogPost> findById = blogPostRepo.findById(id);
		BlogPost blogPost = findById.orElseThrow(()->new ResourceNotFoundException("BlogPost", "ID", id));
		return mapEntityToDto(blogPost);
	}




	public List<BlogPostDto> getAllBlogPost(Pageable page) {
		
		

		Page<BlogPost> findAll = blogPostRepo.findAll(page);
		/*
		 * List<BlogPostDto> blohgpostdtos=new ArrayList<>(); for(BlogPost
		 * blogPost:findAll) {
		 * 
		 * blohgpostdtos.add( mapEntityToDto(blogPost)); }
		 * 
		 */
		
		
		
		List<BlogPost> blogPosts = findAll.getContent();
		 List<BlogPostDto> list = blogPosts.stream().map(blogPost->mapEntityToDto(blogPost)).toList();
		 BlogPostResponse blogPostResponse=new BlogPostResponse();
			blogPostResponse.setBlogPost(list);
			blogPostResponse.setPageNo(page.getPageNumber());
			blogPostResponse.setPageSize(page.getPageSize());
			return list;
	}



	@Override
	public BlogPostDto updateBlogPost(BlogPostDto blogpostdto) {
		Optional<BlogPost> findById = blogPostRepo.findById(blogpostdto.getBlogId());
		BlogPost update =null;
		if(findById.isPresent()) {
			 update = blogPostRepo.save(mapDtoToEntity(blogpostdto));
		}else {
			throw new ResourceNotFoundException("BlogPost", "ID", blogpostdto.getBlogId());
		}
		  return mapEntityToDto(update);
	}

	

	@Override
	public void deletePostById(Integer id) {
	        // get post by id from the database
	        BlogPost post = blogPostRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("BlogPost", "id", id));
	        blogPostRepo.delete(post);
	}

}
