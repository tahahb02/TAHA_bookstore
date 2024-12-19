package com.example.bookstore.service;

import com.example.bookstore.entity.book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public interface BookService {

    public void save(book b1);

    public List<book> searchBooksByName(String book_name);

    public List<book> getall();

    public book getbyid(Long id);

    public void delete(Long id);


}
