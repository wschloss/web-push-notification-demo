package io.walter.notifications.config.context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

public class FirebaseContext {

    private FirebaseOptions firebaseOptions;

    public FirebaseContext(final FirebaseOptions firebaseOptions) {

        this.firebaseOptions = firebaseOptions;
        FirebaseApp.initializeApp(firebaseOptions);
    }

    public FirebaseMessaging currentFirebaseMessaging() {

        return FirebaseMessaging.getInstance();
    }
}
