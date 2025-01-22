package com.example.emailservice.producers;

import com.example.emailservice.dtos.SendEmailDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendEmailProducer {
    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;


    public SendEmailProducer(KafkaTemplate<String, String> kafkaTemplate
                , ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendEmail(SendEmailDto email) throws JsonProcessingException {
        kafkaTemplate.send("sendemail", objectMapper.writeValueAsString(email));
        return "Email sent successfully";
    }

}
