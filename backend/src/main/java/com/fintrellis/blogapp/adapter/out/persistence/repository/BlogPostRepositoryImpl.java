package com.fintrellis.blogapp.adapter.out.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;
import com.fintrellis.blogapp.adapter.out.persistence.jpa.BlogPostJpaRepository;
import com.fintrellis.blogapp.adapter.out.persistence.mapper.BlogPostEntityMapper;
import com.fintrellis.blogapp.application.port.out.BlogPostRepository;
import com.fintrellis.blogapp.domain.exception.BlogPostNotFoundException;
import com.fintrellis.blogapp.domain.model.BlogPost;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BlogPostRepositoryImpl implements BlogPostRepository {

    private final BlogPostJpaRepository repo;
    private final BlogPostEntityMapper mapper;

    @Override
    public List<BlogPost> findAll() {
        return mapper.toDomain(repo.findAll());
    }

    @Override
    public BlogPost findById(Long id) {
        return mapper.toDomain(repo.findById(id)
            .orElseThrow(() -> new BlogPostNotFoundException(id)));
    }

    @Override
    public BlogPost save(BlogPost post) {
        BlogPostEntity entity = mapper.toEntity(post);
        return mapper.toDomain(repo.save(entity));
    }

    @Override
    public void update(BlogPost post) {
        repo.findById(post.id())
            .orElseThrow(() -> new BlogPostNotFoundException(post.id()));

        repo.save(mapper.toEntity(post));
    }

    @Override
    public void delete(Long id) {
        BlogPostEntity post = repo.findById(id).orElseThrow(() -> new BlogPostNotFoundException(id));
        repo.delete(post);
    }
}
