package com.rabbitmq.producer.controller;

import com.rabbitmq.producer.model.RequestMessageModel;
import com.rabbitmq.producer.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RabbitController {
    private final MessageProducer messageProducer;

    @PostMapping
    public ResponseEntity<String> produce(@RequestBody RequestMessageModel requestMessageModel) {
        messageProducer.send(requestMessageModel);
        return ResponseEntity.ok("Ok");
    }
}
