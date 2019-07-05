package io.walter.notifications.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Receiver {

    @JsonProperty("deviceToken")
    private final String deviceToken;

    @JsonCreator
    public Receiver(@JsonProperty("deviceToken") final String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @JsonGetter
    public String getDeviceToken() {
        return deviceToken;
    }
}
