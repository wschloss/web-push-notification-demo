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

    private final String FIREBASE_PROJECT_DATABASE_URL_ENV_PROPERTY = "FIREBASE_PROJECT_DATABASE_URL";

    @Bean
    public MessagingDao getMessagingDao() {
        return new FcmMessagingDao();
    }

    @Bean
    public FirebaseContext getFirebaseContext() throws IOException {

        final String FIREBASE_PROJECT_DATABASE_URL = System.getenv(FIREBASE_PROJECT_DATABASE_URL_ENV_PROPERTY);

        final FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl(FIREBASE_PROJECT_DATABASE_URL)
                .build();

        return new FirebaseContext(options);
    }
}
