package com.example.emailservice.consumers;

import com.example.emailservice.dtos.SendEmailDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SendEmailConsumer {
    private ObjectMapper objectMapper;

    public SendEmailConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener (topics = "sendemail", groupId = "receiver_group")
    public void consumeEmail(String email) throws JsonProcessingException {
        SendEmailDto emailDto = objectMapper.readValue(email, SendEmailDto.class);
        System.out.println("Email consumed: " + emailDto.getEmail());
        System.out.println("Email consumed: " + emailDto.getMessage());

    }

}
