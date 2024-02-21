package com.rabbitmq.consumer.consumer;

import com.rabbitmq.consumer.model.RequestMessageModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MessageConsumer {

    @Value("${rabbitmq.topics.test-topic}")
    private String queueName;

    @RabbitListener(queues = "${rabbitmq.topics.test-topic}")
    public void readMessageFromQueue(RequestMessageModel message) {
        log.info("Message: '{}' obtained from queue: '{}'", message, queueName);
    }
}
