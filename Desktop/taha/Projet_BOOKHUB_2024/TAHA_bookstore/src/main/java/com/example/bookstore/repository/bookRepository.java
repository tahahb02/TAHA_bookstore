package com.example.bookstore.repository;

import com.example.bookstore.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface bookRepository extends JpaRepository<book,Long> {


    List<book> findAllByName(String name);
}
