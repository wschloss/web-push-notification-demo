package io.walter.notifications.config;

import io.walter.notifications.dao.MessagingDao;
import io.walter.notifications.dao.stub.StubMessagingDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfiguration {

    @Bean
    public MessagingDao getMessagingDao() {
        return new StubMessagingDao();
    }
}
