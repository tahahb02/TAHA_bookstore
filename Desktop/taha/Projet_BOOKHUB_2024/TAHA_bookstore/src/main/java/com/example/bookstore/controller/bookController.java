package com.example.bookstore.controller;

import com.example.bookstore.entity.Mybook;
import com.example.bookstore.entity.book;
import com.example.bookstore.service.BookService_Imp;
import com.example.bookstore.service.MybookService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class bookController {

    @Autowired
    BookService_Imp imp;
    @Autowired
    MybookService_Imp imp1;
    @Autowired
    private BookService_Imp bookService_Imp;

    @GetMapping("/home_users")
    public String homeUsers(Model model) {
        List<book> books = imp.getall();
        model.addAttribute("books", books);
        return "home_users";
    }


    @GetMapping("/home_admin")
    public String homeAdmin() {
        return "home_admin";
    }

    @GetMapping("/")
    public String home(){
        return "home_admin";
    }

    @GetMapping("/book_register")
    public String register(){
        return "addBook";
    }

    @GetMapping("/Available_book")
    public String getallbook(Model model){
        List<book> books = imp.getall();
        model.addAttribute("books", books);
        return "Available_book";
    }


    @PostMapping("/save")
    public String savebooks(@ModelAttribute book b1){
        imp.save(b1);
        return "redirect:/Available_book";
    }

    @GetMapping("/available_book_users")
    public String getmybook(Model model){
        List<book> b1 = imp.getall();
        model.addAttribute("books",b1);
        return "available_book_users";
    }

    @GetMapping("/favoriteBook")
    public String getFavoriteBooks(Model model){
        List<Mybook> favoriteBooks = imp1.getallmybooks();
        model.addAttribute("favoriteBooks", favoriteBooks);
        return "favoriteBook";
    }

    @GetMapping("/favoriteBook/{id}")
    public String getmylist(@PathVariable("id") Long id ){
        book b = imp.getbyid(id);
        Mybook b1 = new Mybook(b.getBook_id() , b.getName() , b.getAuther() , b.getPrice() ,b.getDescription());
        imp1.save(b1);
        return "redirect:/favoriteBook";
    }

    @RequestMapping("/delete/{id}")
    public String deletebook(@PathVariable("id") Long id){
        imp.delete(id);
        return "redirect:/Available_book";
    }
    @RequestMapping("/deleteFavorite/{id}")
    public String deletefavoritebook(@PathVariable("id") Long id){
        imp1.delete(id);
        return "redirect:/favoriteBook";
    }
    @RequestMapping("/deletemybook/{id}")
    public String deletemybook(@PathVariable("id") Long id){
        imp1.delete(id);
        return "redirect:/available_book_users";
    }

    @RequestMapping( "/editbook/{id}" )
    public String editbook(@PathVariable("id") Long id, Model model){
        book b = imp.getbyid(id);
        model.addAttribute("book",b);
        return "editbook";
    }


    @PostMapping( "/search" )
    public String searchbook(@RequestParam String book_name,Model model){
        List<book> books = imp.searchBooksByName(book_name);
        model.addAttribute("books",books);
        return "available_book_users";
    }

    @PostMapping("/searchadmin")
    public String searchadminbook(@RequestParam String book_name,Model model){
        List<book> books = imp.searchBooksByName(book_name
        );
        model.addAttribute("books", books);
        return "Available_book";
    }
}
