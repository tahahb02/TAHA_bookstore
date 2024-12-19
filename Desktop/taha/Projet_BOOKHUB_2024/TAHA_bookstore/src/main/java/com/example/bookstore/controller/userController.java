package com.example.bookstore.controller;


import com.example.bookstore.entity.user;
import com.example.bookstore.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

@Controller
public class userController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private userRepository repo ;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/signin")
    public String login(){
        return "login";
    }


    @PostMapping("/signin")
    public String processlogin(@RequestParam String email , @RequestParam String password){
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(email, password);

            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            // You can return user details or a JWT token here if you are using JWT for authentication
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            String role = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElse("No role found");
            if(role.equals("ROLE-USER"))
                return "redirect:/home_users";
            else
                return "redirect:/home_admin";
        } catch (AuthenticationException e) {
            return "Authentication failed: " + e.getMessage();
        }
    }



    @GetMapping("/register")
    public String signup(Model model){
        model.addAttribute("user", new user());
        return "register";
    }

    @GetMapping("/user")
    public String user(){
        return "home_users";
    }

    @GetMapping("/admin")
    public String admin(){
        return "home_admin";
    }
//
//    @GetMapping("/available_book_users")



    @PostMapping("/register")
    public String processRegistration(user u  , RedirectAttributes ra){
        System.out.println("hi");
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setRole("ROLE-USER");
        repo.save(u);
        ra.addFlashAttribute("msg","Registration Successfully");
        return "redirect:/register";
    }
}
