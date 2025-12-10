package com.fintrellis.blogapp.adapter.in.web;

import com.fintrellis.blogapp.adapter.in.web.dto.AddPostRequest;
import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;
import com.fintrellis.blogapp.application.port.in.AddBlogPostUseCase;
import com.fintrellis.blogapp.application.port.in.commands.AddBlogPostCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final AddBlogPostUseCase addBlogPost;

    @GetMapping("/posts")
    public String getAllPosts() {
        return "All blog posts";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable Long id) {
        return "Post with id " + id;
    }

    @PostMapping("/posts")
    public BlogPostEntity addPost(@RequestBody AddPostRequest req) {

        return addBlogPost.add(new AddBlogPostCommand(req.title(), req.content()));
    }

    @PutMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id) {
        return "Updating post with id " + id;
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id) {
        return "Deleting post with id " + id;
    }
}
