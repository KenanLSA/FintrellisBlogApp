package com.fintrellis.blogapp.domain.model;

import lombok.Data;

@Data
public class BlogPost {
    Long id;
    String title;
    String content;
}
