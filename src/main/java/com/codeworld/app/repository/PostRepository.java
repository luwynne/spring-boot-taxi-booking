package com.codeworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeworld.app.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
