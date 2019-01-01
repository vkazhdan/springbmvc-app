package com.springb.controller;

import com.springb.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "index";
    }

}