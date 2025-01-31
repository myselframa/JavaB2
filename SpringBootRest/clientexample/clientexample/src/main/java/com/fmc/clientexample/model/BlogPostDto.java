package com.fmc.clientexample.model;



import lombok.Data;

@Data
public class BlogPostDto {
	
	private Integer blogId;
	private String content;
	private String discription;
	private String title;

}