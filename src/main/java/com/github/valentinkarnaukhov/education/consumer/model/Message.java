package com.github.valentinkarnaukhov.education.consumer.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class Message {

    @Id
    private String id;

    private UUID uuid;
    private UUID companyUuid;
    private String text;
    private Instant timestamp;

}
