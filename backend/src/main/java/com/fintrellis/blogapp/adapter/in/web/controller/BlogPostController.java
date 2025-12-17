package com.fintrellis.blogapp.adapter.in.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintrellis.blogapp.adapter.in.web.dto.BlogPostCreateDto;
import com.fintrellis.blogapp.adapter.in.web.dto.BlogPostUpdateDto;
import com.fintrellis.blogapp.adapter.out.persistence.dto.BlogPostResponseDto;
import com.fintrellis.blogapp.adapter.out.persistence.mapper.BlogPostDtoMapper;
import com.fintrellis.blogapp.application.port.in.AddBlogPostUseCase;
import com.fintrellis.blogapp.application.port.in.DeleteBlogPostUseCase;
import com.fintrellis.blogapp.application.port.in.FindAllBlogPostUseCase;
import com.fintrellis.blogapp.application.port.in.FindBlogPostByIdUseCase;
import com.fintrellis.blogapp.application.port.in.UpdateBlogPostUseCase;
import com.fintrellis.blogapp.application.port.in.commands.AddBlogPostCommand;
import com.fintrellis.blogapp.application.port.in.commands.DeleteBlogPostCommand;
import com.fintrellis.blogapp.application.port.in.commands.FindByIdCommand;
import com.fintrellis.blogapp.application.port.in.commands.UpdateBlogPostCommand;
import com.fintrellis.blogapp.domain.model.BlogPost;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class BlogPostController {

    private static final Logger logger = LoggerFactory.getLogger(BlogPostController.class);

    private final BlogPostDtoMapper mapper;
    private final FindAllBlogPostUseCase findAllUseCase;
    private final AddBlogPostUseCase addUseCase;
    private final FindBlogPostByIdUseCase findByIdUseCase;
    private final DeleteBlogPostUseCase deletetUseCase;
    private final UpdateBlogPostUseCase updateUseCase;

    @GetMapping
    public ResponseEntity<List<BlogPostResponseDto>> getAllBlogPost() {
        logger.info("Incoming request GET /api/v1/posts");

        List<BlogPost> posts = findAllUseCase.findAll();

        logger.info("Request completed GET /api/v1/posts, status=200");

        return ResponseEntity.ok(mapper.toDto(posts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPostResponseDto> getById(@PathVariable Long id) {
        logger.info("Incoming request GET /api/v1/posts/" + id);
        
        BlogPost post = findByIdUseCase.findById(new FindByIdCommand(id));

        logger.info("Request completed GET /api/v1/posts/{}, status=200", id);

        return ResponseEntity.ok(mapper.toDto(post));
    }

    @PostMapping
    public ResponseEntity<BlogPostResponseDto> addBlogPost(@RequestBody BlogPostCreateDto post) {
        logger.info("Incoming request POST /api/v1/posts");

        BlogPost newPost = addUseCase.save(new AddBlogPostCommand(post.title(), post.content()));

        logger.info("Request completed POST /api/v1/posts/{}, status=201", newPost.id());

        return ResponseEntity.ok(mapper.toDto(newPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        logger.info("Incoming request DELETE /api/v1/posts/{}", id);

        deletetUseCase.delete(new DeleteBlogPostCommand(id));

        logger.info("Request completed DELETE /api/v1/posts/{} status=204", id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BlogPostUpdateDto dto) {
        logger.info("Incoming request PUT /api/v1/posts/" + id);

        updateUseCase.update(
            new UpdateBlogPostCommand(id, dto.title(), dto.content())
        );

        logger.info("Request completed PUT /api/v1/posts/{} status=204", id);

        return ResponseEntity.noContent().build();
    }
}
