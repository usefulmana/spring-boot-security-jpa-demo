package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/user")
    public User addUserByAdmin(@RequestBody User user){
        String pw = user.getPassword();
        String encryptedPassword = bCryptPasswordEncoder.encode(pw);
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/greet")
    public String greet(){
        return "Hello";
    }
}
