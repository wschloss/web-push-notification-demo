# DEMO: push notifications

Contains a spring web service for sending messages through FCM. Web service has a 'local' and 'production' mvn profile for local stubs and production FCM messaging.
Service account key file is supplied to FCM from evn variable pointing to the json file. Location is defined in the pom.xml.
Had to create an FCM project in the firebase console, then create a new key for the admin service account in order to obtain the json creds file.

In addition, contains a UI to register to push notifications and receive them. Cloned the firebase quickstart-js project from github and then followed the messaging/ directory readme. This required setting up firebase CLI and adding the app to it before starting the UI server.

1 - Start up the server in prod mode so that it sends to FCM
```
mvn -Pproduction clean spring-boot:run
```

2 - The ui was taken from firebase quickstart-js. Start up the ui using firebase cli
```
cd quickstart-web-ui/
firebase serve -p 8081
```

3 - Send a request to the local web service to send a message through FCM. The UI will display the token
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
