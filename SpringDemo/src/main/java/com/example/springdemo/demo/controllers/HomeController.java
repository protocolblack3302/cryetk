package com.example.springdemo.demo.controllers;

import com.example.springdemo.demo.domains.Authorities;
import com.example.springdemo.demo.domains.Users;
import com.example.springdemo.demo.repositories.AuthorityRepository;
import com.example.springdemo.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;


@GetMapping
public String home(Model model){

    model.addAttribute("user",new Users());

    return "home";
}

@PostMapping
    public String processHome(Model model,@ModelAttribute(name="user") Users user){
    model.addAttribute("user",user);
    Authorities authorities=new Authorities();
    authorities.setUsername(user.getUsername());
    authorityRepository.save(authorities);
    userRepository.save(user.justEncode(passwordEncoder));
    return "redirect:/design";
}



}
