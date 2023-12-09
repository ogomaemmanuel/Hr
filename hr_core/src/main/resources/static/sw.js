importScripts("/js/dist/precache-manifest.19215545484707cb1141a09a66c08d86.js", "https://storage.googleapis.com/workbox-cdn/releases/4.3.1/workbox-sw.js");

importScripts('https://www.gstatic.com/firebasejs/7.12.0/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/7.12.0/firebase-messaging.js');

workbox.core.skipWaiting();

workbox.core.clientsClaim();
workbox.precaching.precacheAndRoute(self.__precacheManifest);
workbox.routing.registerRoute(
    /login/,
    new workbox.strategies.NetworkFirst()
);
/**
 * caches only html request files with pretty url, urls with .html, problematic for now
 * https://www.thepolyglotdeveloper.com/2019/03/service-workers-workbox-hugo-static-generated-site/
 */

// workbox.routing.registerRoute(/(?:\/)$/, workbox.strategies.NetworkFirst({
//     "cacheName": "html",
//     plugins: [new workbox.expiration.Plugin({"maxAgeSeconds": 604800, "purgeOnQuotaError": false})]
// }), 'GET');
workbox.routing.registerRoute(
    /\.(?:png|gif|jpg|jpeg|webp|svg)$/,
    new workbox.strategies.CacheFirst({
        cacheName: 'images'
        // plugins: [
        //     new ExpirationPlugin({
        //         maxEntries: 60,
        //         maxAgeSeconds: 30 * 24 * 60 * 60, // 30 Days
        //     }),
        // ],
    })
);
workbox.routing.registerRoute(
    /\.(?:js|css|woff2)$/,
    new workbox.strategies.StaleWhileRevalidate({
        cacheName: 'static-resources',
    })
);

