package com.example.kafkaConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "test-topic", groupId = "test-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumer(List<ConsumerRecord<String, String>> records, Acknowledgment acknowledgment) {
       for (ConsumerRecord<String, String> record: records) {
           String message = record.value();
           System.out.println("Received message: " + message);
       }
       acknowledgment.acknowledge();
    }
}
