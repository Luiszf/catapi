package com.luis.simplerestapi.repository;

import com.luis.simplerestapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
