package com.springb.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultController {

	@ModelAttribute
	public void handle(Model model, @AuthenticationPrincipal User user) {
		model.addAttribute("currentUser", user);
	}

}
