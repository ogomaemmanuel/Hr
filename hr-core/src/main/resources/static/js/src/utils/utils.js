import * as SockJS from 'sockjs-client';
const Stomp = require("stompjs/lib/stomp.js").Stomp
function formatToCurrency(value) {
    return (value).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
}
function formattedDate() {
        return moment(value).format('LLL');
}
function formattedTime() {
        return moment(value).format('LT');
}
const sockJsConnection = function () {
    let socket =new SockJS("/web-chat");
    let stompClient = Stomp.over(socket);
    return stompClient;
}
const registerServiceWorker = () => {
    if ('serviceWorker' in navigator) {
        navigator.serviceWorker.register('/sw.js').then(function (registration) {
            console.log('ServiceWorker registration successful with scope: ', registration.scope);
        }, function (err) {
            // registration failed :(
            console.log('ServiceWorker registration failed: ', err);
        });
    }
}
function unregisterServiceWorker() {
    if ('serviceWorker' in navigator) {
        navigator.serviceWorker.ready.then(registration => {
            registration.unregister();
        });
    }
}
export  default {
    formatToCurrency,
    formattedTime,
    formattedDate,
    sockJsConnection,
    registerServiceWorker,
    unregisterServiceWorker
}