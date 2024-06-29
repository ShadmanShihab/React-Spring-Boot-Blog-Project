package com.app.demoproject.service;

import com.app.demoproject.dto.BlogPostDTO;
import com.app.demoproject.model.BlogPost;
import com.app.demoproject.repo.BlogPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private CategoryService categoryService;

    public List<BlogPost> getAllBlogPosts() {
        List<BlogPost> blogPostList = blogPostRepository.findAll();
        return blogPostList;
    }

    public Optional<BlogPost> getBlogPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    public BlogPost createBlogPost(BlogPostDTO blogPostDTO) {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(blogPostDTO.getTitle());
        blogPost.setContent(blogPostDTO.getContent());
        blogPost.setAuthor(blogPostDTO.getAuthor());
        blogPost.setCategory(categoryService.getCategoryById(blogPostDTO.getCategoryId()));
        blogPost.setCreatedAt(LocalDateTime.now());
        blogPost.setUpdatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }

    public BlogPost updateBlogPost(Long id, BlogPost blogPostDetails) {
        BlogPost blogPost = blogPostRepository.findById(id).orElseThrow(() -> new RuntimeException("BlogPost not found"));
        blogPost.setTitle(blogPostDetails.getTitle());
        blogPost.setContent(blogPostDetails.getContent());
        blogPost.setAuthor(blogPostDetails.getAuthor());
        blogPost.setCategory(blogPostDetails.getCategory());
        blogPost.setCreatedAt(blogPostDetails.getCreatedAt());
        blogPost.setUpdatedAt(blogPostDetails.getUpdatedAt());
        return blogPostRepository.save(blogPost);
    }

    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }

    public List<BlogPost> getBlogPostsByCategoryId(Long categoryId) {
        List<BlogPost> blogPostList = blogPostRepository.findAllByCategoryId(categoryId);
        return blogPostList;
    }
}
