package com.fintrellis.blogapp.application.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fintrellis.blogapp.application.port.in.FindBlogPostByIdUseCase;
import com.fintrellis.blogapp.application.port.in.commands.FindByIdCommand;
import com.fintrellis.blogapp.application.port.out.BlogPostRepository;
import com.fintrellis.blogapp.domain.model.BlogPost;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindBlogPostById implements FindBlogPostByIdUseCase {
    private final BlogPostRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(FindBlogPostById.class);

    @Override
    public BlogPost findById(FindByIdCommand command) {
        logger.info("Finding blog post where id={}", command.id());
        return repo.findById(command.id());
    } 
}
