package com.example.bookstore.controller;


import com.example.bookstore.entity.Mybook;
import com.example.bookstore.entity.book;
import com.example.bookstore.service.MybookService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MybookController {

    @Autowired
    MybookService_Imp mybook_repo;


    @RequestMapping( "/editMybook/{id}" )
    public String editbook(@PathVariable("id") Long id, Model model){
        Mybook b = mybook_repo.getbyid(id);
        model.addAttribute("Mybook",b);
        return "editbook";
    }


    @PostMapping("/savee")
    public String savebooks(@ModelAttribute Mybook b1){
        mybook_repo.save(b1);
        return "redirect:/Mybook";
    }

}
