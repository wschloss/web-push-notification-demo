package io.walter.notifications.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty("title")
    private final String title;
    @JsonProperty("message")
    private final String message;

    @JsonCreator
    public Message(@JsonProperty("title") final String title,
                   @JsonProperty("message") final String message) {

        this.title = title;
        this.message = message;
    }

    @JsonGetter
    public String getTitle() {
        return title;
    }

    @JsonGetter
    public String getMessage() {
        return message;
    }
}
