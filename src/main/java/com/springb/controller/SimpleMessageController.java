package com.springb.controller;

import com.springb.domain.Message;
import com.springb.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/simplemessage")
public class SimpleMessageController {


    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody String add(@RequestParam String text) {
        Message message = new Message();
        message.setText(text);
        Message savedMessage = messageRepository.save(message);
        return "Saved: " + savedMessage;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Message> getAll() {
        // This returns a JSON or XML with the messages
        return messageRepository.findAll();
    }

    @GetMapping(path = "/find") // Map ONLY GET Requests
    public @ResponseBody String find(@RequestParam String text) {
        return "Result: " + messageRepository.findByTextContaining(text);
    }

}