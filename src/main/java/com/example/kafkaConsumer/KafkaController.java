package com.example.kafkaConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            String msg = message + "_" + i;
            kafkaTemplate.send("test-topic", msg);
            System.out.println("Send message: " + msg);
            Thread.sleep(1000);
        }
        return "hello world";

    }
}
