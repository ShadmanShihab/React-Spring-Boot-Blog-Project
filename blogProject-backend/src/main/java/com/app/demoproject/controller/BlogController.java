package com.app.demoproject.controller;

import com.app.demoproject.dto.BlogPostDTO;
import com.app.demoproject.model.BlogPost;
import com.app.demoproject.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogposts")
public class BlogController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        List<BlogPost> list = blogPostService.getAllBlogPosts();
        return list;
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity getBlogPostsByCategory(@PathVariable Long categoryId) {
        List<BlogPost> list = blogPostService.getBlogPostsByCategoryId(categoryId);
        if (list != null && list.size() > 0) {
            return ResponseEntity.ok(list);
        }
//        return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/{id}")
    public Optional<BlogPost> getBlogPostById(@PathVariable Long id) {
        return blogPostService.getBlogPostById(id);
    }

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPostDTO blogPostDTO) {
        return blogPostService.createBlogPost(blogPostDTO);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPostDetails) {
        return blogPostService.updateBlogPost(id, blogPostDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
    }
}
