package com.springb.controller;

import com.springb.domain.User;
import com.springb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        // Validate
        if (CollectionUtils.isEmpty(user.getRoles())) {
            model.addAttribute("message", "Role(s) not selected!");
            return "registration";
        }

        if (userService.isUserExistByUsername(user.getUsername())) {
            model.addAttribute("message", String.format("User: '%s' already exists!", user.getUsername()));
            return "registration";
        }

        // Create
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode password
        userService.create(user);

        return "redirect:/login";
    }
}