package com.ourhome.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.ourhome.chat.interceptor.WebSocketBrokerInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfiguration implements WebSocketMessageBrokerConfigurer {

	private final WebSocketBrokerInterceptor interceptor;
	
	WebSocketBrokerConfiguration(WebSocketBrokerInterceptor interceptor) {
		this.interceptor = interceptor;
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws/init")
				.setAllowedOrigins("*");
	}
	
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.interceptors(interceptor);
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/sub");
		registry.setApplicationDestinationPrefixes("/pub");
	}
	
	
}
