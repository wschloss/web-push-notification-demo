package io.walter.notifications.service;

import io.walter.notifications.dao.MessagingDao;
import io.walter.notifications.models.Message;
import io.walter.notifications.models.Receiver;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificationService {

    @Autowired
    private MessagingDao messagingDao;

    public String sendNotification(final Message message, final Receiver receiver) {

        final String messageId = messagingDao.sendMessage(message, receiver);
        return messageId;
    }
}
