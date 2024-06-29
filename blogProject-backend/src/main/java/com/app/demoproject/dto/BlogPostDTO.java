package com.app.demoproject.dto;

import lombok.Data;

@Data
public class BlogPostDTO {
    private String title;

    private String content;

    private String author;

    private Long categoryId;
}
