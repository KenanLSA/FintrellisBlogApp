package com.fintrellis.blogapp.application.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fintrellis.blogapp.application.port.in.UpdateBlogPostUseCase;
import com.fintrellis.blogapp.application.port.in.commands.UpdateBlogPostCommand;
import com.fintrellis.blogapp.application.port.out.BlogPostRepository;
import com.fintrellis.blogapp.domain.model.BlogPost;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateBlogPost implements UpdateBlogPostUseCase {

    private final BlogPostRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(UpdateBlogPost.class);

    @Override
    public void update(UpdateBlogPostCommand command) {
        logger.info("Updating blog post where id={}", command.id());
        repo.update(new BlogPost(command.id(), command.title(), command.content()));
    }
    
}
