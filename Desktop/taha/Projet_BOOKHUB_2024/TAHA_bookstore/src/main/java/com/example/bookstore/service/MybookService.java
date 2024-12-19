package com.example.bookstore.service;


import com.example.bookstore.entity.Mybook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MybookService {

    public void save (Mybook b1);
    public List<Mybook> getallmybooks();

    public void delete (Long id );

    public Mybook getbyid(Long id);
}
