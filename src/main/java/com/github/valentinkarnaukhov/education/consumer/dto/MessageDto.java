package com.github.valentinkarnaukhov.education.consumer.dto;

import com.github.valentinkarnaukhov.education.consumer.model.Message;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

public class MessageDto {

    @Getter
    @Setter
    public static class MessageGetRequest {
        private UUID companyUuid;
        private Instant fromDate;
        private Instant toDate;
    }

    @Setter
    @Getter
    public static class MessageGetResponse {
        private UUID uuid;
        private UUID companyUuid;
        private String text;
        private Instant timestamp;

        public MessageGetResponse(Message message) {
            this.uuid = message.getUuid();
            this.companyUuid = message.getCompanyUuid();
            this.text = message.getText();
            this.timestamp = message.getTimestamp();
        }
    }
}
