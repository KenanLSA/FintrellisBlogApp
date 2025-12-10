package com.fintrellis.blogapp.adapter.out.persistence.jpa;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostSpringJpa extends JpaRepository<BlogPostEntity, Long> {
    BlogPostEntity save(BlogPostEntity post);
}
