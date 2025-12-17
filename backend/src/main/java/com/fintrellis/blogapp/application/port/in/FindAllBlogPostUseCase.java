package com.fintrellis.blogapp.application.port.in;

import java.util.List;

import com.fintrellis.blogapp.domain.model.BlogPost;

public interface FindAllBlogPostUseCase {
    List<BlogPost> findAll();
}
