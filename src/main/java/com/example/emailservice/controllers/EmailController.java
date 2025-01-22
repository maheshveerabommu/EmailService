package com.example.emailservice.controllers;

import com.example.emailservice.dtos.SendEmailDto;
import com.example.emailservice.producers.SendEmailProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    private SendEmailProducer sendEmailProducer;

    public EmailController(SendEmailProducer sendEmailProducer,
                ObjectMapper objectMapper) {
        this.sendEmailProducer = sendEmailProducer;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody SendEmailDto email) throws JsonProcessingException {
        return sendEmailProducer.sendEmail(email);
    }
}
