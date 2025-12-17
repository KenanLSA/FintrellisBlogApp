package com.fintrellis.blogapp.application.usecase;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fintrellis.blogapp.application.port.in.FindAllBlogPostUseCase;
import com.fintrellis.blogapp.application.port.out.BlogPostRepository;
import com.fintrellis.blogapp.domain.model.BlogPost;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllBlogPost implements FindAllBlogPostUseCase {
    
    private final BlogPostRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(FindAllBlogPost.class);

    @Override
    public List<BlogPost> findAll() {
        logger.info("Finding all blog posts");
        return repo.findAll();
    }
    
}
