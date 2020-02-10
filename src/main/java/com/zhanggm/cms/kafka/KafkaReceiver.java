package com.zhanggm.cms.kafka;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {
	
	public KafkaReceiver() {
		System.out.println("KafkaReceiver ...");
	}
	
	@KafkaListener(topics = {"1710f"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record);
        System.out.println("KafkaReceiver ...");
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("record:" + record);
            System.out.println("message:" + message);
        }
    }
	
}
