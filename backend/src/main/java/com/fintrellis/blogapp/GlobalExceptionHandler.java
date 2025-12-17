package com.fintrellis.blogapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fintrellis.blogapp.domain.exception.BlogPostNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BlogPostNotFoundException.class)
    public ResponseEntity<?> BlogPostNotFoundExceptionHandler(BlogPostNotFoundException e) {

        logger.error("Blog Post not found - status=404");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
