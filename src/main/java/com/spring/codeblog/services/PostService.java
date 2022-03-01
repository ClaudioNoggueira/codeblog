package com.spring.codeblog.services;

import java.util.List;

import com.spring.codeblog.entities.Post;

public interface PostService {

    void savePost(Post obj);

    List<Post> findAll();

    Post findPostById(Long id);
}
