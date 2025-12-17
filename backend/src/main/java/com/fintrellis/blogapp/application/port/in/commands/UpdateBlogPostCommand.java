package com.fintrellis.blogapp.application.port.in.commands;

public record UpdateBlogPostCommand(Long id, String title, String content) {
    
}
