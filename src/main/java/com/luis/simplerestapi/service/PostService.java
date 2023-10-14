package com.luis.simplerestapi.service;

import com.luis.simplerestapi.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post save(Post post);

    List<Post> listAll();

    Optional<Post> findById(Long id);

    Post update(Post post);

    void deleteById(Long id);
}
