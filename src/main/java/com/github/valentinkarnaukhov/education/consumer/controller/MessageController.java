package com.github.valentinkarnaukhov.education.consumer.controller;

import com.github.valentinkarnaukhov.education.consumer.dto.MessageDto;
import com.github.valentinkarnaukhov.education.consumer.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    public List<MessageDto.MessageGetResponse> getMessagesByParameter(MessageDto.MessageGetRequest searchParameters) {
        return messageService.getMessages(searchParameters);
    }

}
