package com.fmg.blog.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="blog_post")
public class BlogPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="blog_id")
	private Integer blogId;
	@Column(name="blog_title")
	private String title;
	@Column(name="blog_discription")
	private String discription;
	@Column(name="blog_content")
	private String content;

}
