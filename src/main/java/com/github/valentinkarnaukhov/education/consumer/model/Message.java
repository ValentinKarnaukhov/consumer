package com.github.valentinkarnaukhov.education.consumer.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Document("messages")
public class Message {

    @Id
    private String id;

    private UUID uuid;
    private UUID companyUuid;
    private UUID userUuid;
    private String text;
    private Instant timestamp;

}
