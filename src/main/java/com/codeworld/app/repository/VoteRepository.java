package com.codeworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeworld.app.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{

}
