package com.fmg.blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmg.blog.entites.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long>{

	List<Comment> findByPostBlogId(long postId);
}
