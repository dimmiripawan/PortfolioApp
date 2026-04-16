package com.portfolio.contact.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.portfolio.contact.model.ContactRequest;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(ContactRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("pavan.tech.soft06@gmail.com"); // where you receive
        message.setSubject("Portfolio Contact from " + request.getName());
        message.setText(
                "Name: " + request.getName() + "\n" +
                "Email: " + request.getEmail() + "\n" +
                "Message: " + request.getMessage()
        );

        mailSender.send(message);
    }
}

