package com.example.bookstore.repository;


import com.example.bookstore.entity.Mybook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MybookRepository extends JpaRepository<Mybook , Long> {

}
