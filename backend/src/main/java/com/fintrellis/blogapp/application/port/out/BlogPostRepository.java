package com.fintrellis.blogapp.application.port.out;

import java.util.List;

import com.fintrellis.blogapp.domain.model.BlogPost;

public interface BlogPostRepository {
    List<BlogPost> findAll();
    BlogPost findById(Long id);
    BlogPost save(BlogPost post);
    void update(BlogPost post);
    void delete(Long id);
}
