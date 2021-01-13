package com.example.springdemo.demo.controllers;

import com.example.springdemo.demo.domains.Authorities;
import com.example.springdemo.demo.domains.Users;
import com.example.springdemo.demo.repositories.AuthorityRepository;
import com.example.springdemo.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private UserRepository userRepository;

    private AuthorityRepository authorityRepository;

    private PasswordEncoder passwordEncoder;

@Autowired
   public HomeController(UserRepository userRepository,AuthorityRepository authorityRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.authorityRepository=authorityRepository;
    }

@GetMapping
public String home(Model model){

    model.addAttribute("user",new Users());

    return "home";
}

@PostMapping
    public String processHome(Model model,Users user){
    model.addAttribute("user",user);
    Authorities authorities=new Authorities();
    authorities.setUsername(user.getUsername());
    authorityRepository.save(authorities);
    userRepository.save(user.justEncode(passwordEncoder));
    return "redirect:/design";
}



}
