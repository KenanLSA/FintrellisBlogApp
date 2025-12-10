package com.fintrellis.blogapp.application.port.in;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;

import java.util.List;

public interface GetAllBlogPostUseCase {
    List<BlogPostEntity> getAll();
}
