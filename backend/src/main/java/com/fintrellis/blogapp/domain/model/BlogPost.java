package com.fintrellis.blogapp.domain.model;

public record BlogPost (Long id, String title, String content) {

    public BlogPost(String title, String content) {
        this(null, title, content);
    }
}