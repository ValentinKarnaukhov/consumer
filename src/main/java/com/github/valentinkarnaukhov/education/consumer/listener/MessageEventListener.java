package com.github.valentinkarnaukhov.education.consumer.listener;

import com.github.valentinkarnaukhov.education.consumer.dto.MessageEvent;
import com.github.valentinkarnaukhov.education.consumer.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
@RequiredArgsConstructor
public class MessageEventListener {

    private static final String TOPIC_NAME = "messages";

    private final MessageService messageService;

    @KafkaListener(topics = TOPIC_NAME)
    public void listenMessageTopic(MessageEvent messageEvent) {
        messageService.saveMessage(messageEvent);
    }

}
