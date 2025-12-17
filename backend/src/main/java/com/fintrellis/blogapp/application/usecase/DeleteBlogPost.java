package com.fintrellis.blogapp.application.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fintrellis.blogapp.application.port.in.DeleteBlogPostUseCase;
import com.fintrellis.blogapp.application.port.in.commands.DeleteBlogPostCommand;
import com.fintrellis.blogapp.application.port.out.BlogPostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteBlogPost implements DeleteBlogPostUseCase {
    
    private final BlogPostRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(DeleteBlogPost.class);

    @Override
    public void delete(DeleteBlogPostCommand command) {
        logger.info("Deleting blog post where id={}", command.id());
        repo.delete(command.id());
    }
    
}
