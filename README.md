# DEMO: push notifications using Firebase Cloud Messaging

Contains a spring web service for sending messages through FCM. Web service has a 'local' and 'production' mvn profile for local stubs and production FCM usage.

In addition, this demo uses a clone of the quickstart-web-ui project from the github firebase quickstart-js repo located [here](https://github.com/firebase/quickstart-js/tree/master/messaging). Reference that README for startup instructions for the UI portion.

### How to run this demo
* You will need to setup a firebase project first. After setup, generate a service account json file for admin SDK usage
* In the pom file, update the maven spring boot plugin configuration to supply the correct environment variables to connect to your Firebase project. They should be set to the Firebase project database URL, and the service account json file path on your system.
* Update quickstart-web-ui/index.html method 'messaging.usePublicVapidKey('')' to specify your firebase projects vapid value.

1 - Start up the server in prod mode so that it connects to your Firebase project
```
mvn -Pproduction clean spring-boot:run
```

2 - The ui was taken from firebase quickstart-js. Start up the ui using firebase cli in a separate terminal.
```
cd quickstart-web-ui/
firebase serve -p 8081
```

3 - Visit localhost:8081 to view the UI and allow push notification permissions. The UI will display the token which targets your web browser.

4 - Send a request to the local web service to send a message through FCM.
```
curl -v -X POST http://localhost:8080/notifications \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  --data '{
            "message": {
              "title":"My Push Notification",
              "message":"I just sent my first push notification"
            },
            "receiver":{
              "deviceToken":"<UI_TOKEN_HERE>"
            }
          }'
```
