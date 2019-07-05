package io.walter.notifications.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import io.walter.notifications.config.context.FirebaseContext;
import io.walter.notifications.dao.MessagingDao;
import io.walter.notifications.dao.impl.FcmMessagingDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Configuration
@Profile("production")
public class ProductionConfiguration {

    private static final String FCM_DATABASE_URL = "https://testwebpush-e37e9.firebaseio.com";

    @Bean
    public MessagingDao getMessagingDao() {
        return new FcmMessagingDao();
    }

    @Bean
    public FirebaseContext getFirebaseContext() throws IOException {

        final FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl(FCM_DATABASE_URL)
                .build();

        return new FirebaseContext(options);
    }
}
