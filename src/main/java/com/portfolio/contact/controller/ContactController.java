package com.portfolio.contact.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.contact.model.ContactRequest;
import com.portfolio.contact.service.EmailService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public Map<String, String> sendMessage(@RequestBody ContactRequest request) {
        emailService.sendEmail(request);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Message sent successfully!");
        return response;
    }
    
}
