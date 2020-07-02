package com.codeworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeworld.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
