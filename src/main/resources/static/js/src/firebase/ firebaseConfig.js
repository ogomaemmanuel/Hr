// https://www.freecodecamp.org/news/how-to-add-push-notifications-to-a-web-app-with-firebase-528a702e13e1/
//import firebase from 'firebase';
import * as firebase from 'firebase/app';
import "firebase/messaging";
import {Message} from "element-ui"
let firebaseConfig = {
    apiKey: "AIzaSyBIYobc3LT6thrDfJlBC6w-ml8p9FD5Alg",
    authDomain: "shoppingcart-71cf0.firebaseapp.com",
    databaseURL: "https://shoppingcart-71cf0.firebaseio.com",
    projectId: "shoppingcart-71cf0",
    storageBucket: "shoppingcart-71cf0.appspot.com",
    messagingSenderId: "769269932934",
    appId: "1:769269932934:web:24588a95d176bd3c1e0207"
};
const initializedFirebaseApp = firebase.initializeApp(firebaseConfig);

const messaging = initializedFirebaseApp.messaging();
/**
 * The onTokenRefresh callback fires whenever a new token is generated, so calling getToken in its context ensures that you are accessing a current, available registration token.
 * Link https://firebase.google.com/docs/cloud-messaging/js/client
 */
messaging.onTokenRefresh(() => {
    // Get Instance ID token. Initially this makes a network call, once retrieved
    // subsequent calls to getToken will return from cache.
    messaging.getToken().then((refreshedToken) => {
        subscribeToFirebaseMessages(refreshedToken);
    }).catch((err) => {
        console.log('Unable to retrieve refreshed token ', err);

    });
});

function subscribeToFirebaseMessages(token) {
    axios.post("/notification/firebase/subscribe",
        {token: token}).then(resp => {
        console.log("subscriptions successful")
    })
}
messaging.onMessage((payload) => {
    console.log("Firebase Message", payload);
    Message.info(payload.data.body);
});
const askForPermissionToReceiveNotifications = () => {
    // A user has already subscribed
    if (Notification.permission == "granted") {
        console.log("A user has already subscribed for notifications")
        return Promise.resolve("")
    }
    //Firebase getToken method ask for Notification permission
    let token = messaging.getToken().then(token => {
        if (!token) {
            console.log('No Instance ID token available. Request permission to generate one.');
        }
        return token
    });
    return token;
}

 export default {
     subscribeToFirebaseMessages,
     askForPermissionToReceiveNotifications
 }
