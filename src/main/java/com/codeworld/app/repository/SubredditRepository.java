package com.codeworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeworld.app.model.Subreddit;

@Repository
public interface SubredditRepository extends JpaRepository<Subreddit, Long>{

}
