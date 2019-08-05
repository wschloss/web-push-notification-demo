package io.walter.notifications.dao.impl;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.WebpushConfig;
import io.walter.notifications.config.context.FirebaseContext;
import io.walter.notifications.dao.MessagingDao;
import io.walter.notifications.models.Message;
import io.walter.notifications.models.Receiver;
import org.springframework.beans.factory.annotation.Autowired;

public class FcmMessagingDao implements MessagingDao {

    @Autowired
    private FirebaseContext firebaseContext;

    @Override
    public String sendMessage(final Message message, final Receiver receiver) {

        // The notification is show to the user and is not tied to a platform
        final Notification firebaseNotification = new Notification(message.getTitle(), message.getMessage());

        final WebpushConfig webpushConfig = WebpushConfig.builder()
                .putData("icon", "firebase-logo.png")
                .putData("click_action","http://localhost:8081")
                .build();

        com.google.firebase.messaging.Message firebaseMessage = com.google.firebase.messaging.Message.builder()
                .setNotification(firebaseNotification)
                .setWebpushConfig(webpushConfig)
                .setToken(receiver.getDeviceToken())
                .putData("generic_fcm_data", "generic_value")
                .build();

        try {
            final String messageId = firebaseContext.currentFirebaseMessaging().send(firebaseMessage);
            return messageId;
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
