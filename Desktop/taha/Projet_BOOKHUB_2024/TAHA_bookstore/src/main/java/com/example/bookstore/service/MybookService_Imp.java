package com.example.bookstore.service;


import com.example.bookstore.entity.Mybook;
import com.example.bookstore.repository.MybookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybookService_Imp implements MybookService{


    @Autowired
    MybookRepository repo;

    public void save (Mybook b1){
        repo.save(b1);
    }

    @Override
    public List<Mybook> getallmybooks() {
       return repo.findAll();
    }

    @Override
    public void delete(Long id){
        repo.deleteById(id);
    }


    @Override
    public Mybook getbyid(Long id){
        return repo.getById(id);
    }


}
