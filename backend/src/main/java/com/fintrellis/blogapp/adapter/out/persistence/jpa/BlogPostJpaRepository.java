package com.fintrellis.blogapp.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;

@Repository
public interface BlogPostJpaRepository extends JpaRepository<BlogPostEntity, Long>{
    
}
