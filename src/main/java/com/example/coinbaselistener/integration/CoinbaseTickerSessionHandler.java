package com.example.coinbaselistener.integration;

import com.example.coinbaselistener.util.SubscriptionMessageReader;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

@Component
@Log4j2
public class CoinbaseTickerSessionHandler implements WebSocketHandler {

    @Autowired
    SubscriptionMessageReader subscriptionMessageReader;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String message = subscriptionMessageReader.asString();
        session.sendMessage(new TextMessage(message));
        log.info("Subscribing with message: \n" + message);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info(message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error(exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("Connection closed. Reason: " + closeStatus.getReason());
    }

    @Override
    public boolean supportsPartialMessages() {
        return true;
    }
}
