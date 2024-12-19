package com.example.bookstore.repository;

import com.example.bookstore.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  userRepository  extends JpaRepository<user,Long> {
    public user findByEmail(String email);

}
