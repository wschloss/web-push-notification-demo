package io.walter.notifications.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationResponse {

    @JsonProperty("messageId")
    private final String messageId;

    @JsonCreator
    public NotificationResponse(@JsonProperty("messageId") final String messageId) {
        this.messageId = messageId;
    }

    @JsonGetter
    public String getMessageId() {
        return messageId;
    }
}
