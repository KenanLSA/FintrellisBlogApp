package com.fintrellis.blogapp.application.port.in;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;
import com.fintrellis.blogapp.application.port.in.commands.AddBlogPostCommand;

public interface AddBlogPostUseCase {
    BlogPostEntity add(AddBlogPostCommand command);
}
