package com.example.kafkaConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "test-topic", groupId = "test-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumer(String message, Acknowledgment acknowledgment) {
        System.out.println("Received message: " + message);
        acknowledgment.acknowledge();
    }
}
