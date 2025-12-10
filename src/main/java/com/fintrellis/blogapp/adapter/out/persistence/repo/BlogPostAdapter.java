package com.fintrellis.blogapp.adapter.out.persistence.repo;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;
import com.fintrellis.blogapp.adapter.out.persistence.jpa.BlogPostSpringJpa;
import com.fintrellis.blogapp.application.port.out.BlogPostPort;
import com.fintrellis.blogapp.domain.model.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogPostAdapter implements BlogPostPort {

    private final BlogPostSpringJpa repo;

    public BlogPostAdapter(BlogPostSpringJpa repo) {
        this.repo = repo;
    }

    @Override
    public BlogPostEntity save(BlogPost post) {

        BlogPostEntity newPost = new BlogPostEntity();
        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());

        return repo.save(newPost);
    }

    @Override
    public List<BlogPostEntity> getAll() {
        return repo.findAll();
    }
}
