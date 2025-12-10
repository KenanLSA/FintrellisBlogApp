package com.fintrellis.blogapp.application.port.out;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;
import com.fintrellis.blogapp.domain.model.BlogPost;

import java.util.List;

public interface BlogPostPort {
    public BlogPostEntity save(BlogPost post);
    public List<BlogPostEntity> getAll();
}
