package com.fmg.blog.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmg.blog.entites.BlogPost;

public interface BlogPostRepo extends JpaRepository<BlogPost, Long>{
 Optional<BlogPost> findByTitle(String title);
}
