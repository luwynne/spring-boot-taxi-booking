package com.codeworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeworld.app.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
