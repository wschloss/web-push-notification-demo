package io.walter.notifications.dao;

import io.walter.notifications.models.Message;
import io.walter.notifications.models.Receiver;

public interface MessagingDao {

    String sendMessage(final Message message, final Receiver receiver);
}
