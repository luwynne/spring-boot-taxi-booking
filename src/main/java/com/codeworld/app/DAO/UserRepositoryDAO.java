package com.codeworld.app.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeworld.app.entity.User;

import java.util.Optional;

public interface UserRepositoryDAO extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
