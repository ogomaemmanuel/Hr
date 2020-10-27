importScripts('https://www.gstatic.com/firebasejs/7.12.0/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/7.12.0/firebase-messaging.js');
firebase.initializeApp({
    apiKey: "AIzaSyBIYobc3LT6thrDfJlBC6w-ml8p9FD5Alg",
    authDomain: "shoppingcart-71cf0.firebaseapp.com",
    databaseURL: "https://shoppingcart-71cf0.firebaseio.com",
    projectId: "shoppingcart-71cf0",
    storageBucket: "shoppingcart-71cf0.appspot.com",
    messagingSenderId: "769269932934",
    appId: "1:769269932934:web:24588a95d176bd3c1e0207"
})

const messaging = firebase.messaging();

messaging.setBackgroundMessageHandler(function (payload) {
    console.log('[firebase-messaging-sw.js] Received background message ', payload);
    return self.registration.showNotification(payload.data.title, {
        body: payload.data.body,
        icon: payload.data.icon,
        tag: payload.data.tag,
        data: payload.data.link
    });
});
self.addEventListener('notificationclick', function (event) {
    event.notification.close();
    event.waitUntil(self.clients.openWindow(event.notification.data.link));
});
