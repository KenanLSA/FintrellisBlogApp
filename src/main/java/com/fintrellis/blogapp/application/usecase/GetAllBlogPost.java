package com.fintrellis.blogapp.application.usecase;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;
import com.fintrellis.blogapp.application.port.in.GetAllBlogPostUseCase;
import com.fintrellis.blogapp.application.port.out.BlogPostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBlogPost implements GetAllBlogPostUseCase {

    private final BlogPostPort repo;

    public List<BlogPostEntity> getAll() {
        return repo.getAll();
    }
}
