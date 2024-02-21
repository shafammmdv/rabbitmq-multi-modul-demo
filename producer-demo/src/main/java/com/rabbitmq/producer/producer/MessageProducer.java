package com.rabbitmq.producer.producer;

import com.rabbitmq.producer.config.RabbitMqConfig;
import com.rabbitmq.producer.model.RequestMessageModel;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MessageProducer {
    RabbitTemplate rabbitTemplate;
    RabbitMqConfig rabbitMqConfig;

    public void send(RequestMessageModel message) {
        rabbitTemplate.convertAndSend(rabbitMqConfig.getQueueName(), message);
        log.info("Message: {} sent to topic: {}", message, rabbitMqConfig.getQueueName());
    }
}
