package com.springb.controller;

import com.springb.domain.Message;
import com.springb.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/message")
public class MessageController {

    private static final String MESSSAGE_PAGE = "message";

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public String add(@RequestParam String text, Model model) {
        // Save message
        Message message = new Message();
        message.setText(text);
        messageRepository.save(message);

        model.addAttribute("messages", messageRepository.findAll());
        return MESSSAGE_PAGE;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return MESSSAGE_PAGE;
    }

    @GetMapping(path = "/find") // Map ONLY GET Requests
    public String find(@RequestParam String text, Model model) {
        model.addAttribute("messages", messageRepository.findByTextContaining(text));
        return MESSSAGE_PAGE;
    }
}