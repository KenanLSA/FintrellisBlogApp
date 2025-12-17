package com.fintrellis.blogapp.application.port.in;

import com.fintrellis.blogapp.application.port.in.commands.DeleteBlogPostCommand;

public interface DeleteBlogPostUseCase {
    void delete(DeleteBlogPostCommand command);
}
