package com.fintrellis.blogapp.adapter.out.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.fintrellis.blogapp.adapter.out.persistence.dto.BlogPostResponseDto;
import com.fintrellis.blogapp.domain.model.BlogPost;

@Mapper(componentModel = "spring")
public interface BlogPostDtoMapper {
    List<BlogPostResponseDto> toDto(List<BlogPost> postList);
    
    BlogPostResponseDto toDto(BlogPost post);
}