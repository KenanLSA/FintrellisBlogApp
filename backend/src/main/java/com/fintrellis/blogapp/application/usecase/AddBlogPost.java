package com.fintrellis.blogapp.application.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fintrellis.blogapp.application.port.in.AddBlogPostUseCase;
import com.fintrellis.blogapp.application.port.in.commands.AddBlogPostCommand;
import com.fintrellis.blogapp.application.port.out.BlogPostRepository;
import com.fintrellis.blogapp.domain.model.BlogPost;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddBlogPost implements AddBlogPostUseCase {

    private final BlogPostRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(AddBlogPost.class);

    @Override
    public BlogPost save(AddBlogPostCommand command) {
        logger.info("Creating Blog Post");
        return repo.save(new BlogPost(command.title(), command.content()));
    }
    
}
