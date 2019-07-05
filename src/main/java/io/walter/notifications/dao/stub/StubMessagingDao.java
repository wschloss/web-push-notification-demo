package io.walter.notifications.dao.stub;

import io.walter.notifications.dao.MessagingDao;
import io.walter.notifications.models.Message;
import io.walter.notifications.models.Receiver;

public class StubMessagingDao implements MessagingDao {

    private final String MESSAGE_ID = "12345";

    @Override
    public String sendMessage(Message message, Receiver receiver) {

        return MESSAGE_ID;
    }
}
