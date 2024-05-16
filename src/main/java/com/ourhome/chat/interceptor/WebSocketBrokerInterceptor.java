package com.ourhome.chat.interceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
public class WebSocketBrokerInterceptor implements ChannelInterceptor {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
		final StompCommand commandType = headerAccessor.getCommand();
		
		if (StompCommand.CONNECT == commandType) {
			
		} else if (StompCommand.SEND == commandType) {
			
		} else if (StompCommand.SUBSCRIBE == commandType) {
			
		}
		
		return ChannelInterceptor.super.preSend(message, channel);
	}
}
