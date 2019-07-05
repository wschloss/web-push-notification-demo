package io.walter.notifications.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationRequest {

    @JsonProperty("message")
    private final Message message;
    @JsonProperty("receiver")
    private final Receiver receiver;

    public NotificationRequest(@JsonProperty("message") final Message message,
                               @JsonProperty("receiver") final Receiver receiver) {

        this.message = message;
        this.receiver = receiver;
    }

    @JsonGetter
    public Message getMessage() {
        return message;
    }

    @JsonGetter
    public Receiver getReceiver() {
        return receiver;
    }
}
