package io.walter.notifications.api;

import io.walter.notifications.models.Message;
import io.walter.notifications.models.NotificationRequest;
import io.walter.notifications.models.NotificationResponse;
import io.walter.notifications.models.Receiver;
import io.walter.notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping(path = "/notifications")
    public NotificationResponse sendNotification(@RequestBody final NotificationRequest notificationRequest) {

        final Message message = notificationRequest.getMessage();
        final Receiver receiver = notificationRequest.getReceiver();

        final String messageId = notificationService.sendNotification(message, receiver);
        return new NotificationResponse(messageId);
    }
}
