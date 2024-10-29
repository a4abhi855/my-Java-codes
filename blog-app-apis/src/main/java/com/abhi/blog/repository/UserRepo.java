package com.abhi.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
