package com.fintrellis.blogapp.application.port.in;

import com.fintrellis.blogapp.application.port.in.commands.AddBlogPostCommand;
import com.fintrellis.blogapp.domain.model.BlogPost;

public interface AddBlogPostUseCase {
    BlogPost save(AddBlogPostCommand command);
}
