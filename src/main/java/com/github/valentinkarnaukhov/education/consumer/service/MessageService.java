package com.github.valentinkarnaukhov.education.consumer.service;

import com.github.valentinkarnaukhov.education.consumer.dto.MessageDto;
import com.github.valentinkarnaukhov.education.consumer.dto.MessageEvent;
import com.github.valentinkarnaukhov.education.consumer.model.Message;
import com.github.valentinkarnaukhov.education.consumer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public UUID saveMessage(MessageEvent messageEvent) {
        Message savedMessage = this.saveMessage(
                messageEvent.getCompanyUuid(),
                messageEvent.getUserUuid(),
                messageEvent.getText(),
                messageEvent.getTimestamp()
        );
        return savedMessage.getUuid();
    }

    public List<MessageDto.MessageGetResponse> getMessages(MessageDto.MessageGetRequest searchParameters) {
        return messageRepository.findAllByParameter(searchParameters).stream()
                .map(MessageDto.MessageGetResponse::new)
                .collect(Collectors.toList());
    }

    private Message saveMessage(UUID companyUuid, UUID userUuid, String text, Instant timestamp) {
        Message message = new Message();
        message.setUuid(UUID.randomUUID());
        message.setUserUuid(userUuid);
        message.setText(text);
        message.setCompanyUuid(companyUuid);
        message.setTimestamp(timestamp);

        return messageRepository.insert(message);
    }

}
