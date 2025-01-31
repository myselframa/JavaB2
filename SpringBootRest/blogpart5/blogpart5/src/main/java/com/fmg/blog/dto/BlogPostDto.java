package com.fmg.blog.dto;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        description = "BlogPostDto Model Information"
)
public class BlogPostDto {
	
	private Long blogId;
	
	
    // post content should not be null or empty
    @NotEmpty
	private String content;
	
    // post description should be not null or empty
    // post description should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
	
	private String discription;
	
    // title should not be null  or empty
    // title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
	private String title;

    private Set<CommentDto> comments;
}
