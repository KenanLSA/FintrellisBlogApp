package com.fintrellis.blogapp.application.port.in;

import com.fintrellis.blogapp.application.port.in.commands.FindByIdCommand;
import com.fintrellis.blogapp.domain.model.BlogPost;

public interface FindBlogPostByIdUseCase {
    BlogPost findById(FindByIdCommand command);
}
