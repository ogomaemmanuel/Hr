package com.ogoma.hr_core.boundaries.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {
    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages
                .nullDestMatcher().authenticated()
                .simpSubscribeDestMatchers("/user/queue/errors").permitAll()
                .simpSubscribeDestMatchers("/topic/**", "/user/**").authenticated()
                .simpDestMatchers("/swat-chat/**").authenticated()
                .anyMessage().denyAll();
    }
    @Override
    protected boolean sameOriginDisabled() {
        // While CSRF is disabled..
        return true;
    }

}
