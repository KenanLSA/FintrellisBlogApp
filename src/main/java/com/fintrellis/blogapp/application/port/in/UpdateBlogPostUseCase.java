package com.fintrellis.blogapp.application.port.in;

import com.fintrellis.blogapp.application.port.in.commands.UpdateBlogPostCommand;

public interface UpdateBlogPostUseCase {
    boolean update(UpdateBlogPostCommand command);
}
