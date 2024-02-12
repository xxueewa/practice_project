### Kafka Spring Boot Project

This is a skeleton project consisting of a Kafka producer and a consumer; 
if posting a message to localhost:8080/send, the producer will produce the kafka events to "test-topic";
there are three consumer instances to consume the events with manual commitment set up to reduce the risk of event loss. 

