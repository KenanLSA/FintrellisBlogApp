package com.fintrellis.blogapp.adapter.out.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.fintrellis.blogapp.adapter.out.persistence.entity.BlogPostEntity;
import com.fintrellis.blogapp.domain.model.BlogPost;

@Mapper(componentModel = "spring")
public interface BlogPostEntityMapper {
    List<BlogPost> toDomain(List<BlogPostEntity> entityList);
    BlogPost toDomain(BlogPostEntity entityList);
    BlogPostEntity toEntity(BlogPost post);
}
