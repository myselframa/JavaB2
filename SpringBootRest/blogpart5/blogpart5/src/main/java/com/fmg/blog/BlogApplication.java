package com.fmg.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;



@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "SpringBoot Blog App Rest APIs",
	        version ="v1.0",
	        termsOfService = "#",
	        contact = @Contact(
	            name = "Fmc Support Team",
	            url = "https://worldnettps.com/contact/",
	            email = "support@worldnettps.com"),
	        license = @License(
	            name = "Use and Distribution License",
	            url = "#"),
	        description = "SpringBoot Blog App")
	    )

public class BlogApplication {


	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	/*
	 * @Override public void run(String... args) throws Exception { BlogPost
	 * blogPost1 = new BlogPost(); blogPost1.setTitle("Spring Boot Introduction");
	 * blogPost1.setDiscription("An introductory guide to Spring Boot."); blogPost1.
	 * setContent("Spring Boot simplifies the process of building Java applications..."
	 * );
	 * 
	 * Comment comment1 = new Comment(); comment1.setName("Alice");
	 * comment1.setEmail("alice@example.com"); comment1.
	 * setBody("Great article! Really helped me get started with Spring Boot.");
	 * comment1.setPost(blogPost1);
	 * 
	 * Comment comment2 = new Comment(); comment2.setName("Bob");
	 * comment2.setEmail("bob@example.com");
	 * comment2.setBody("Informative content, thanks for sharing!");
	 * comment2.setPost(blogPost1);
	 * 
	 * 
	 * 
	 * // Create second blog post BlogPost blogPost2 = new BlogPost();
	 * blogPost2.setTitle("Understanding Hibernate");
	 * blogPost2.setDiscription("A deep dive into Hibernate ORM."); blogPost2.
	 * setContent("Hibernate is an ORM framework that simplifies database interactions..."
	 * );
	 * 
	 * Comment comment3 = new Comment(); comment3.setName("Charlie");
	 * comment3.setEmail("charlie@example.com");
	 * comment3.setBody("Excellent explanation of Hibernate concepts.");
	 * comment3.setPost(blogPost2);
	 * 
	 * Comment comment4 = new Comment(); comment4.setName("Diana");
	 * comment4.setEmail("diana@example.com");
	 * comment4.setBody("Looking forward to implementing this in my project!");
	 * comment4.setPost(blogPost2);
	 * 
	 * 
	 * 
	 * blogpostrepo.save(blogPost1); blogpostrepo.save(blogPost2);
	 * commentRepo.save(comment1); commentRepo.save(comment2);
	 * commentRepo.save(comment3); commentRepo.save(comment4);
	 * 
	 * }
	 */

}
