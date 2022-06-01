package com.ogoma.hr_core.boundaries.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/web-chat")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    //https://stackoverflow.com/questions/25928047/spring-stomp-subscribemapping-user-with-user-destination-doesnt-work
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/swat-chat");
        registry.enableSimpleBroker("/topic/", "/queue/");
        registry.setUserDestinationPrefix("/user");
        registry.setPreservePublishOrder(true);

//        registry.enableStompBrokerRelay("/topic").setRelayHost("localhost").setRelayPort(61613).setClientLogin("homestead")
//                .setClientPasscode("secret");


    }

}
