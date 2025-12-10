package com.fintrellis.blogapp.application.usecase;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;
import com.fintrellis.blogapp.application.port.in.AddBlogPostUseCase;
import com.fintrellis.blogapp.application.port.in.commands.AddBlogPostCommand;
import com.fintrellis.blogapp.application.port.out.BlogPostPort;
import com.fintrellis.blogapp.domain.model.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddBlogPost implements AddBlogPostUseCase {

    private final BlogPostPort repo;

    @Override
    public BlogPostEntity add(AddBlogPostCommand command) {
        BlogPost newPost = new BlogPost();
        newPost.setTitle(command.title());
        newPost.setContent(command.content());

        return repo.save(newPost);
    }
}
