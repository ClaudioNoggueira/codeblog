package com.spring.codeblog.repositories;

import com.spring.codeblog.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
