package io.walter.notifications.config;

import io.walter.notifications.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {

    @Bean
    public NotificationService getNotificationService() {
        return new NotificationService();
    }
}
