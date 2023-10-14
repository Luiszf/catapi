package com.luis.simplerestapi.service;

import com.luis.simplerestapi.model.Post;
import com.luis.simplerestapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> listAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }


    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
