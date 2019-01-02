package com.springb.controller;

import com.springb.domain.Role;
import com.springb.domain.User;
import com.springb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        if (userService.isUserExistByUsername(user.getUsername())) {
            model.addAttribute("message", String.format("User: '%s' already exists!", user.getUsername()));
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.createUser(user);

        return "redirect:/registration";
    }
}