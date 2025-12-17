package com.fintrellis.blogapp.domain.exception;

public class BlogPostNotFoundException extends RuntimeException {
    public BlogPostNotFoundException(Long id) {
        String message = String.format("Blog post with Id: %d not found", id);
        super(message);
    }
}
