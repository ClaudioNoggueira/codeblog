package com.spring.codeblog.services.servicesImpl;

import java.util.List;

import com.spring.codeblog.entities.Post;
import com.spring.codeblog.repositories.PostRepository;
import com.spring.codeblog.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repo;

    @Override
    public void savePost(Post obj) {
        repo.save(obj);
    }

    @Override
    public List<Post> findAll() {
        return repo.findAll();
    }

    @Override
    public Post findPostById(Long id) {
        return repo.findById(id).get();
    }

}
